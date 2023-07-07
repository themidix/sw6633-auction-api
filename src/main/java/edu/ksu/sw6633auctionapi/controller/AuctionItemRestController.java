package edu.ksu.sw6633auctionapi.controller;

import edu.ksu.sw6633auctionapi.dto.AuctionItemDTO;
import edu.ksu.sw6633auctionapi.service.AuctionItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auction-api")
@CrossOrigin("*")
public class AuctionItemRestController {

    private AuctionItemService auctionItemService;

    public AuctionItemRestController(AuctionItemService auctionItemService) {
        this.auctionItemService = auctionItemService;
    }

    @RequestMapping(value = "/auction-api",method = RequestMethod.POST,produces = "application/json")
    public AuctionItemDTO createAuctionItem(@RequestBody AuctionItemDTO auctionItemDTO){
        return auctionItemService.createAuctionItem(auctionItemDTO);
    }

   // @GetMapping("/{auctionItemId}")
    @RequestMapping(value = "/loadAuctionItemById/{auctionItemId}",method = RequestMethod.GET,produces = "application/json")
    public AuctionItemDTO loadAuctionItemById(@PathVariable Long auctionItemId){
        return auctionItemService.loadAuctionItemById(auctionItemId);
    }
}
