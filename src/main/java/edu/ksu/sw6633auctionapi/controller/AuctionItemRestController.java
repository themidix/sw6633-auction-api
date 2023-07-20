package edu.ksu.sw6633auctionapi.controller;

import edu.ksu.sw6633auctionapi.dto.AuctionItemDTO;
import edu.ksu.sw6633auctionapi.entity.AuctionItem;
import edu.ksu.sw6633auctionapi.service.AuctionItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auction-api")
@CrossOrigin("*")
public class AuctionItemRestController {

    private AuctionItemService auctionItemService;

    public AuctionItemRestController(AuctionItemService auctionItemService) {
        this.auctionItemService = auctionItemService;
    }

    @RequestMapping(value = "/createAuctionItem",method = RequestMethod.POST,produces = "application/json")
    public AuctionItemDTO createAuctionItem(@RequestBody AuctionItemDTO auctionItemDTO){
        return auctionItemService.createAuctionItem(auctionItemDTO);
    }

   // @GetMapping("/{auctionItemId}")
    @RequestMapping(value = "/loadAuctionItemById/{auctionItemId}",method = RequestMethod.GET,produces = "application/json")
    public AuctionItemDTO loadAuctionItemById(@PathVariable Long auctionItemId){
        return auctionItemService.loadAuctionItemById(auctionItemId);
    }
    @RequestMapping(value = "/findAuctionItemByCategory",method = RequestMethod.GET,produces = "application/json")
    public Page<AuctionItemDTO> findAuctionItemByCategory(@RequestParam(name = "categoryName", defaultValue = "") String categoryName,
                                                       @RequestParam(name = "page", defaultValue = "0") int page,
                                                       @RequestParam(name = "size", defaultValue = "5") int size){
        return auctionItemService.findAuctionItemByCategory(categoryName, page, size);
    }
    @RequestMapping(value = "/loadAuctionItemByCategory/{categoryName}",method = RequestMethod.GET,produces = "application/json")
    public List<AuctionItem> loadAuctionItemByCategory(@PathVariable String categoryName){
        return auctionItemService.loadAuctionItemByCategory(categoryName);
    }
    @RequestMapping(value = "/getAllAuctionItems",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AuctionItemDTO> getAllAuctionItems(){
        return auctionItemService.getAllAuctionItems();
    }
}
