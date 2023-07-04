package edu.ksu.sw6633auctionapi.mapper;

import edu.ksu.sw6633auctionapi.dto.AuctionItemDTO;
import edu.ksu.sw6633auctionapi.entity.AuctionItem;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AuctionItemMapper {

   public AuctionItemDTO fromAuctionItem(AuctionItem auctionItem){
       AuctionItemDTO auctionItemDTO = new AuctionItemDTO();
       BeanUtils.copyProperties(auctionItem,auctionItemDTO);
       return auctionItemDTO;
   }
   public AuctionItem fromAuctionItemDTO(AuctionItemDTO auctionItemDTO){
       AuctionItem auctionItem = new AuctionItem();
       BeanUtils.copyProperties(auctionItemDTO,auctionItem);
       return auctionItem;
   }
}
