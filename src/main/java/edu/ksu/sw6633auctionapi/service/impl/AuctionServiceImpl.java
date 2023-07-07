package edu.ksu.sw6633auctionapi.service.impl;

import edu.ksu.sw6633auctionapi.dto.AuctionItemDTO;
import edu.ksu.sw6633auctionapi.dto.RegisteredUserDTO;
import edu.ksu.sw6633auctionapi.entity.AuctionItem;
import edu.ksu.sw6633auctionapi.entity.Bid;
import edu.ksu.sw6633auctionapi.entity.Category;
import edu.ksu.sw6633auctionapi.entity.RegisteredUser;
import edu.ksu.sw6633auctionapi.mapper.AuctionItemMapper;
import edu.ksu.sw6633auctionapi.mapper.RegisteredUserMapper;
import edu.ksu.sw6633auctionapi.repository.AuctionItemRepository;
import edu.ksu.sw6633auctionapi.repository.BidRepository;
import edu.ksu.sw6633auctionapi.repository.CategoryRepository;
import edu.ksu.sw6633auctionapi.repository.RegisteredUserRepository;
import edu.ksu.sw6633auctionapi.service.AuctionItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuctionServiceImpl implements AuctionItemService {

    private AuctionItemRepository auctionItemRepository;
    private AuctionItemMapper auctionItemMapper;

    private RegisteredUserRepository registeredUserRepository;

    private BidRepository bidRepository;

    private CategoryRepository categoryRepository;


    public AuctionServiceImpl(AuctionItemRepository auctionItemRepository, AuctionItemMapper auctionItemMapper, RegisteredUserRepository registeredUserRepository, BidRepository bidRepository, CategoryRepository categoryRepository) {
        this.auctionItemRepository = auctionItemRepository;
        this.auctionItemMapper = auctionItemMapper;
        this.registeredUserRepository = registeredUserRepository;
        this.bidRepository = bidRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public AuctionItemDTO createAuctionItem(AuctionItemDTO auctionItemDTO) {
        AuctionItem auctionItem = auctionItemMapper.fromAuctionItemDTO(auctionItemDTO);
        Category category = categoryRepository.findById(auctionItemDTO.getCategoryDTO().getCategoryId()).orElseThrow(() -> new EntityNotFoundException("Category with ID " + auctionItemDTO.getCategoryDTO().getCategoryId() + " Not Found"));;
        RegisteredUser registeredUser = registeredUserRepository.findById(auctionItemDTO.getRegisteredUserDTO().getRegisteredUserId()).orElseThrow( ()->new EntityNotFoundException("RegisteredUser with ID " + auctionItemDTO.getRegisteredUserDTO().getRegisteredUserId() + " Not Found"));
        auctionItem.setCategory(category);
        auctionItem.setRegisteredUser(registeredUser);
        AuctionItem savedAuctionItem = auctionItemRepository.save(auctionItem);
        return auctionItemMapper.fromAuctionItem(savedAuctionItem);
    }

    @Override
    public AuctionItemDTO updateAuctionItem(AuctionItemDTO auctionItemDTO) {
        AuctionItem loadedAuctionItem = auctionItemRepository.findById(auctionItemDTO.getAuctionItemId()).orElse(null);
//        RegisteredUser registeredUser = registeredUserRepository.findById(auctionItemDTO.getRegisteredUserDTO().getRegisteredUserId()).orElse(null);
//        Bid highestBid = bidRepository.findById(auctionItemDTO.getCurrentHighestBidDTO().getBidId()).orElse(null);
        AuctionItem auctionItem = auctionItemMapper.fromAuctionItemDTO(auctionItemDTO);
        //auctionItem.setRegisteredUser(registeredUser);
        //auctionItem.setCurrentHighestBid(highestBid);
        AuctionItem updateAuctionItem = auctionItemRepository.save(loadedAuctionItem);
        return  auctionItemMapper.fromAuctionItem(updateAuctionItem);
    }

    @Override
    public Page<AuctionItemDTO> findAuctionItemByStatus(boolean status, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return auctionItemRepository.findAuctionItemByStatus(status, pageRequest);
    }

    @Override
    public AuctionItemDTO loadAuctionItemById(Long auctionItemId) {
        AuctionItem auctionItem = auctionItemRepository.findById(auctionItemId).orElse(null);
        return auctionItemMapper.fromAuctionItem(auctionItem);
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
