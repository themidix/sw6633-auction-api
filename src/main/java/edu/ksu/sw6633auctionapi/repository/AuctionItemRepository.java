package edu.ksu.sw6633auctionapi.repository;

import edu.ksu.sw6633auctionapi.dto.AuctionItemDTO;
import edu.ksu.sw6633auctionapi.entity.AuctionItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long> {
    @Query(value = "select * from auction_items where category_id in (select c.category_id from categories as c where c.category_name=:categoryName", nativeQuery = true)
   //@Query(value = "select a from AuctionItem as a where  a.category.categoryName=:categoryName")
    List<AuctionItem> loadAuctionItemByCategory(@Param("categoryName") String categoryName);
    @Query(value = "select a from AuctionItem as a where  a.auctionItemStatus=:status")
    Page<AuctionItemDTO> findAuctionItemByStatus(@Param("status") boolean status, Pageable pageable);

   // @Query(value = "select a from AuctionItem as a where  a.category.categoryName=:catgoryName")
    @Query(value = "select * from auction_items where category_id in (select e.category_id from categories as e where e.category_name=:categoryName)", nativeQuery = true)
    Page<AuctionItem> findAuctionItemByCategoryName(@Param("categoryName") String  categoryName, Pageable pageable);


    @Query(value = "select a from AuctionItem as a where  a.auctionItemId=:auctionItemId")
    AuctionItemDTO loadAuctionItemById(@Param("auctionItemId")Long auctionItemId);
}
