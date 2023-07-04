package edu.ksu.sw6633auctionapi.service;

import edu.ksu.sw6633auctionapi.dto.BidDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BidService {

    BidDTO createABid(BidDTO bidDTO);
    BidDTO placeABid(BidDTO bidDTO);
    List<BidDTO> getBidsByAuctionId(Long auctionId);
}
