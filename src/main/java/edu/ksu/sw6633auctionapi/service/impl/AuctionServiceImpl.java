package edu.ksu.sw6633auctionapi.service.impl;

import edu.ksu.sw6633auctionapi.dto.AuctionItemDTO;
import edu.ksu.sw6633auctionapi.entity.AuctionItem;
import edu.ksu.sw6633auctionapi.entity.Bid;
import edu.ksu.sw6633auctionapi.entity.RegisteredUser;
import edu.ksu.sw6633auctionapi.mapper.AuctionItemMapper;
import edu.ksu.sw6633auctionapi.repository.AuctionItemRepository;
import edu.ksu.sw6633auctionapi.repository.BidRepository;
import edu.ksu.sw6633auctionapi.repository.RegisteredUserRepository;
import edu.ksu.sw6633auctionapi.service.AuctionItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuctionServiceImpl implements AuctionItemService {

    private AuctionItemRepository auctionItemRepository;
    private AuctionItemMapper auctionItemMapper;

    private RegisteredUserRepository registeredUserRepository;

    private BidRepository bidRepository;


    public AuctionServiceImpl(AuctionItemRepository auctionItemRepository, AuctionItemMapper auctionItemMapper, RegisteredUserRepository registeredUserRepository, BidRepository bidRepository) {
        this.auctionItemRepository = auctionItemRepository;
        this.auctionItemMapper = auctionItemMapper;
        this.registeredUserRepository = registeredUserRepository;
        this.bidRepository = bidRepository;
    }

    @Override
    public AuctionItemDTO createAuctionItem(AuctionItemDTO auctionItemDTO) {
        AuctionItem auctionItem = auctionItemMapper.fromAuctionItemDTO(auctionItemDTO);
        RegisteredUser registeredUser = registeredUserRepository.findRegisteredUserByEmail(auctionItemDTO.getRegisteredUserDTO().getUser().getEmail());
        //Bid initialBid = bidRepository.getReferenceById(auctionItemDTO.getCurrentHighestBidDTO().getBidId());
        Bid initialBid = bidRepository.save(auctionItem.getCurrentHighestBid());
        auctionItem.setRegisteredUser(registeredUser);
        auctionItem.setCurrentHighestBid(initialBid);
        AuctionItem savedAuctionItem = auctionItemRepository.save(auctionItem);
        return auctionItemMapper.fromAuctionItem(savedAuctionItem);
    }

    @Override
    public AuctionItemDTO updateAuctionItem(AuctionItemDTO auctionItemDTO) {
        AuctionItem loadedAuctionItem = auctionItemMapper.fromAuctionItemDTO(auctionItemDTO);
        RegisteredUser registeredUser = registeredUserRepository.findRegisteredUserByEmail(auctionItemDTO.getRegisteredUserDTO().getUser().getEmail());
        AuctionItem auctionItem = new AuctionItem();
        auctionItem.setRegisteredUser(registeredUser);
        AuctionItem updateAuctionItem = auctionItemRepository.save(loadedAuctionItem);
        return  auctionItemMapper.fromAuctionItem(updateAuctionItem);
    }

    @Override
    public Page<AuctionItemDTO> findAuctionItemByStatus(boolean status, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return auctionItemRepository.findAuctionItemByStatus(status, pageRequest);
    }

    @Override
    public List<AuctionItemDTO> getAllAuctionItems() {
        return auctionItemRepository.findAll().stream().map(auctionItem -> auctionItemMapper.fromAuctionItem(auctionItem)).collect(Collectors.toList());
    }

    @Override
    public void removeAuctionItem(Long auctionItemId) {
        auctionItemRepository.deleteById(auctionItemId);
    }
}
