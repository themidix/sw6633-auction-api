package edu.ksu.sw6633auctionapi.service;

import edu.ksu.sw6633auctionapi.dto.AuctionItemDTO;
import edu.ksu.sw6633auctionapi.entity.AuctionItem;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AuctionItemService {

    AuctionItemDTO createAuctionItem(AuctionItemDTO auctionItemDTO);
    AuctionItemDTO updateAuctionItem(AuctionItemDTO auctionItemDTO);
    Page<AuctionItemDTO> findAuctionItemByStatus(boolean status, int page, int size);
    Page<AuctionItemDTO> findAuctionItemByCategory(String  categoryName, int page, int size);
    AuctionItemDTO loadAuctionItemById(Long auctionItemId);

    List<AuctionItem> loadAuctionItemByCategory(String categoryName);
    List<AuctionItemDTO> getAllAuctionItems();
    void removeAuctionItem(Long auctionItemId);

}
