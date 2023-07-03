package edu.ksu.sw6633auctionapi.repository;

import edu.ksu.sw6633auctionapi.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {
}
