package edu.ksu.sw6633auctionapi.repository;

import edu.ksu.sw6633auctionapi.dto.BidDTO;
import edu.ksu.sw6633auctionapi.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {

    @Query(value = "select b from Bid as b where b.auctionItem.auctionItemId=:auctionId")
    List<BidDTO> getBidsByAuctionId(@Param("auctionId") Long auctionId);
}
