package edu.ksu.sw6633auctionapi.dto;
import java.time.LocalDateTime;
public class BidDTO {

    private Long bidId;
    private String comment;
    private double amount;
    private LocalDateTime placedAt;
    private AuctionItemDTO auctionItemDTO;
    private RegisteredUserDTO registeredUserDTO;


    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(LocalDateTime placedAt) {
        this.placedAt = placedAt;
    }

    public AuctionItemDTO getAuctionItemDTO() {
        return auctionItemDTO;
    }

    public void setAuctionItemDTO(AuctionItemDTO auctionItemDTO) {
        this.auctionItemDTO = auctionItemDTO;
    }

    public RegisteredUserDTO getRegisteredUserDTO() {
        return registeredUserDTO;
    }

    public void setRegisteredUserDTO(RegisteredUserDTO registeredUserDTO) {
        this.registeredUserDTO = registeredUserDTO;
    }
}
