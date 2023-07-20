package edu.ksu.sw6633auctionapi.controller;

import edu.ksu.sw6633auctionapi.dto.BidDTO;
import edu.ksu.sw6633auctionapi.service.BidService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bids")
public class BidRestDController {

    private BidService bidService;

    public BidRestDController(BidService bidService) {
        this.bidService = bidService;
    }

    @RequestMapping(value = "/placeABids",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public BidDTO placeABid(@RequestBody BidDTO bidDTO){
        return bidService.placeABid(bidDTO);
    }
}
