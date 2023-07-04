package edu.ksu.sw6633auctionapi.service.impl;

import edu.ksu.sw6633auctionapi.dto.BidDTO;
import edu.ksu.sw6633auctionapi.entity.Bid;
import edu.ksu.sw6633auctionapi.entity.RegisteredUser;
import edu.ksu.sw6633auctionapi.mapper.BidMapper;
import edu.ksu.sw6633auctionapi.repository.BidRepository;
import edu.ksu.sw6633auctionapi.repository.RegisteredUserRepository;
import edu.ksu.sw6633auctionapi.service.BidService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class BidServiceImpl implements BidService {

    private BidRepository bidRepository;
    private BidMapper bidMapper;

    private RegisteredUserRepository registeredUserRepository;

    public BidServiceImpl(BidRepository bidRepository, BidMapper bidMapper, RegisteredUserRepository registeredUserRepository) {
        this.bidRepository = bidRepository;
        this.bidMapper = bidMapper;
        this.registeredUserRepository = registeredUserRepository;
    }

    @Override
    public BidDTO createABid(BidDTO bidDTO) {
        Bid bid = bidMapper.fromBidDTO(bidDTO);
        RegisteredUser registeredUser = registeredUserRepository.findRegisteredUserByEmail(bidDTO.getAuctionItemDTO().getRegisteredUserDTO().getUser().getEmail());
        bid.setRegisteredUser(registeredUser);
        Bid savedBid = bidRepository.save(bid);
        return bidMapper.fromBid(savedBid);
    }

    @Override
    public BidDTO placeABid(BidDTO bidDTO) {
        Bid bid = bidMapper.fromBidDTO(bidDTO);
        RegisteredUser registeredUser = registeredUserRepository.findRegisteredUserByEmail(bidDTO.getRegisteredUserDTO().getUser().getEmail());
        double bidAmount = bid.getAmount();
        if(bidAmount < getHighestBid(bidDTO.getAuctionItemDTO().getAuctionItemId())){
            throw new ArithmeticException();
        }
        bid.setAmount(bidAmount);
        bid.setRegisteredUser(registeredUser);
        Bid updateBid = bidRepository.save(bid);
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
        return null;
    }
}
