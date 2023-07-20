package edu.ksu.sw6633auctionapi.service.impl;

import edu.ksu.sw6633auctionapi.dto.AuctionItemDTO;
import edu.ksu.sw6633auctionapi.dto.BidDTO;
import edu.ksu.sw6633auctionapi.dto.CategoryDTO;
import edu.ksu.sw6633auctionapi.dto.RegisteredUserDTO;
import edu.ksu.sw6633auctionapi.entity.AuctionItem;
import edu.ksu.sw6633auctionapi.entity.Bid;
import edu.ksu.sw6633auctionapi.entity.Category;
import edu.ksu.sw6633auctionapi.entity.RegisteredUser;
import edu.ksu.sw6633auctionapi.mapper.AuctionItemMapper;
import edu.ksu.sw6633auctionapi.repository.AuctionItemRepository;
import edu.ksu.sw6633auctionapi.repository.BidRepository;
import edu.ksu.sw6633auctionapi.repository.CategoryRepository;
import edu.ksu.sw6633auctionapi.repository.RegisteredUserRepository;
import edu.ksu.sw6633auctionapi.service.AuctionItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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

//    @Override
//    public Page<AuctionItemDTO> findAuctionItemByCategory(String categoryName, int page, int size) {
//        PageRequest pageRequest = PageRequest.of(page, size);
//        Page<AuctionItem>  auctionItemPage = auctionItemRepository.findAuctionItemByCategoryName(categoryName,pageRequest);
//        return new PageImpl<>(auctionItemPage.getContent().stream().map(auctionItem -> auctionItemMapper.fromAuctionItem(auctionItem)).collect(Collectors.toList()));
//    }
    @Override
    public Page<AuctionItemDTO> findAuctionItemByCategory(String categoryName, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<AuctionItem> auctionItemPage = auctionItemRepository.findAuctionItemByCategoryName(categoryName, pageRequest);

        List<AuctionItemDTO> auctionItemDTOList = auctionItemPage.getContent().stream()
                .map(auctionItem -> {
                    AuctionItemDTO auctionItemDTO = auctionItemMapper.fromAuctionItem(auctionItem);

                    // Map the associated CategoryDTO
                    Category category = auctionItem.getCategory();
                    if (category != null) {
                        CategoryDTO categoryDTO = new CategoryDTO();
                        categoryDTO.setCategoryId(category.getCategoryId());
                        categoryDTO.setCategoryName(category.getCategoryName());
                        auctionItemDTO.setCategoryDTO(categoryDTO);
                    }

                    // Map the associated currentHighestBidDTO
                    Bid currentHighestBid = auctionItem.getCurrentHighestBid();
                    if (currentHighestBid != null) {
                        BidDTO currentHighestBidDTO = new BidDTO();
                        currentHighestBidDTO.setBidId(currentHighestBid.getBidId());
                        currentHighestBidDTO.setComment(currentHighestBid.getComment());
                        currentHighestBidDTO.setAmount(currentHighestBid.getAmount());
                        // Map other attributes if applicable
                       // auctionItemDTO.setCurrentHighestBidDTO(currentHighestBidDTO);
                    }

                    // Map the associated registeredUserDTO
                    RegisteredUser registeredUser = auctionItem.getRegisteredUser();
                    if (registeredUser != null) {
                        RegisteredUserDTO registeredUserDTO = new RegisteredUserDTO();
                        registeredUserDTO.setRegisteredUserId(registeredUser.getRegisteredUserId());
                        // Map other attributes if applicable
                        auctionItemDTO.setRegisteredUserDTO(registeredUserDTO);
                    }

                    return auctionItemDTO;
                })
                .collect(Collectors.toList());

        return new PageImpl<>(auctionItemDTOList, pageRequest, auctionItemPage.getTotalElements());
    }


    public List<AuctionItem> loadAuctionItemByCategory(String categoryName){
         return auctionItemRepository.loadAuctionItemByCategory(categoryName);
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
