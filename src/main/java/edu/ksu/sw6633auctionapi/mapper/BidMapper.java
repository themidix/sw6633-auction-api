package edu.ksu.sw6633auctionapi.mapper;

import edu.ksu.sw6633auctionapi.dto.BidDTO;
import edu.ksu.sw6633auctionapi.entity.Bid;
import org.springframework.beans.BeanUtils;

public class BidMapper {
    public BidDTO fromBid(Bid bid){
        BidDTO bidDTO = new BidDTO();
        BeanUtils.copyProperties(bid,bidDTO);
        return bidDTO;
    }
    public Bid fromBidDTO(BidDTO bidDTO){
        Bid bid = new Bid();
        BeanUtils.copyProperties(bidDTO,bid);
        return bid;
    }
}
