package edu.ksu.sw6633auctionapi.repository;

import edu.ksu.sw6633auctionapi.dto.AuctionItemDTO;
import edu.ksu.sw6633auctionapi.entity.AuctionItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long> {

    //@Query(value = "select * from auction_items where category_id in (select c.category_id from categories as c where c.category_name=:categoryName", nativeQuery = true)
    @Query(value = "select a from AuctionItem as a where  a.category.categoryName=:categoryName")
    Optional<AuctionItem> loadAuctionItemByCategory(@Param("categoryName") String categoryName);
    @Query(value = "select a from AuctionItem as a where  a.auctionItemStatus=:status")
    Page<AuctionItemDTO> findAuctionItemByStatus(@Param("status") boolean status, PageRequest pageRequest);
}
