package edu.ksu.sw6633auctionapi.service.impl;

import edu.ksu.sw6633auctionapi.dto.AuctionItemDTO;
import edu.ksu.sw6633auctionapi.dto.BidDTO;
import edu.ksu.sw6633auctionapi.entity.AuctionItem;
import edu.ksu.sw6633auctionapi.entity.Bid;
import edu.ksu.sw6633auctionapi.entity.RegisteredUser;
import edu.ksu.sw6633auctionapi.mapper.AuctionItemMapper;
import edu.ksu.sw6633auctionapi.mapper.BidMapper;
import edu.ksu.sw6633auctionapi.repository.AuctionItemRepository;
import edu.ksu.sw6633auctionapi.repository.BidRepository;
import edu.ksu.sw6633auctionapi.repository.RegisteredUserRepository;
import edu.ksu.sw6633auctionapi.service.AuctionItemService;
import edu.ksu.sw6633auctionapi.service.BidService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class BidServiceImpl implements BidService {

    private BidRepository bidRepository;
    private BidMapper bidMapper;
    private RegisteredUserRepository registeredUserRepository;
    private AuctionItemRepository auctionItemRepository;
    private AuctionItemService auctionItemService;

    public BidServiceImpl(BidRepository bidRepository, BidMapper bidMapper, RegisteredUserRepository registeredUserRepository, AuctionItemRepository auctionItemRepository, AuctionItemService auctionItemService) {
        this.bidRepository = bidRepository;
        this.bidMapper = bidMapper;
        this.registeredUserRepository = registeredUserRepository;
        this.auctionItemRepository = auctionItemRepository;
        this.auctionItemService = auctionItemService;
    }

    @Override
    public BidDTO createABid(BidDTO bidDTO) {
        Bid bid = bidMapper.fromBidDTO(bidDTO);
        RegisteredUser registeredUser = registeredUserRepository.findRegisteredUserByEmail(bidDTO.getAuctionItemDTO().getRegisteredUserDTO().getUser().getEmail());
        AuctionItem auctionItem = auctionItemRepository.findById(bidDTO.getAuctionItemDTO().getAuctionItemId()).orElseThrow(() -> new EntityNotFoundException("Auction item with ID " + bidDTO.getAuctionItemDTO().getAuctionItemId() + " Not Found"));
        bid.setRegisteredUser(registeredUser);
        bid.setAuctionItem(auctionItem);
        Bid savedBid = bidRepository.save(bid);
        return bidMapper.fromBid(savedBid);
    }

    @Override
    public BidDTO placeABid(BidDTO bidDTO) {
        Bid bid = bidMapper.fromBidDTO(bidDTO);
        RegisteredUser registeredUser = registeredUserRepository.findById(bidDTO.getRegisteredUserDTO().getRegisteredUserId()).orElse(null);
        AuctionItem auctionItem = auctionItemRepository.findById(bidDTO.getAuctionItemDTO().getAuctionItemId()).orElse(null);
        double bidAmount = bid.getAmount();
//        if(bidAmount < getHighestBid(bidDTO.getAuctionItemDTO().getAuctionItemId())){
//            throw new ArithmeticException();
//        }
        bid.setAmount(bidAmount);
        bid.setAuctionItem(auctionItem);
        bid.setRegisteredUser(registeredUser);
        Bid updateBid = bidRepository.save(bid);
        auctionItem.setCurrentHighestBid(bid);
        AuctionItemMapper mapper = new AuctionItemMapper();
        AuctionItemDTO auctionItemDTO = mapper.fromAuctionItem(auctionItem);
        auctionItemService.updateAuctionItem(auctionItemDTO);
        return bidMapper.fromBid(updateBid);
    }

    private double getHighestBid(Long auctionItemId){
        List<Double> bidAmounts = new ArrayList<>();
        List<BidDTO> bidList = bidRepository.getBidsByAuctionId(auctionItemId);
        for(BidDTO highest: bidList)
            bidAmounts.add(highest.getAmount());
        return Collections.max(bidAmounts);
    }

    @Override
    public List<BidDTO> getBidsByAuctionId(Long auctionId) {
        return bidRepository.getBidsByAuctionId(auctionId);
    }
}
