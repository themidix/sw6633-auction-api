package edu.ksu.sw6633auctionapi.dto;

import java.time.LocalDateTime;

public class AuctionItemDTO {

    private Long auctionItemId;
    private String auctionItmImgUrl;
    private String description;
    private double startingPrice;
    private boolean auctionItemStatus;
    private LocalDateTime startingTime;
    private LocalDateTime closingTime;

    private CategoryDTO categoryDTO;

//    private BidDTO currentHighestBidDTO;

    private RegisteredUserDTO registeredUserDTO;

    public Long getAuctionItemId() {
        return auctionItemId;
    }

    public void setAuctionItemId(Long auctionItemId) {
        this.auctionItemId = auctionItemId;
    }

    public String getAuctionItmImgUrl() {
        return auctionItmImgUrl;
    }

    public void setAuctionItmImgUrl(String auctionItmImgUrl) {
        this.auctionItmImgUrl = auctionItmImgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public boolean isAuctionItemStatus() {
        return auctionItemStatus;
    }

    public void setAuctionItemStatus(boolean auctionItemStatus) {
        this.auctionItemStatus = auctionItemStatus;
    }

    public LocalDateTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalDateTime startingTime) {
        this.startingTime = startingTime;
    }

    public LocalDateTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalDateTime closingTime) {
        this.closingTime = closingTime;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public RegisteredUserDTO getRegisteredUserDTO() {
        return registeredUserDTO;
    }

    public void setRegisteredUserDTO(RegisteredUserDTO registeredUserDTO) {
        this.registeredUserDTO = registeredUserDTO;
    }

//    public BidDTO getCurrentHighestBidDTO() {
//        return currentHighestBidDTO;
//    }
//
//    public void setCurrentHighestBidDTO(BidDTO currentHighestBidDTO) {
//        this.currentHighestBidDTO = currentHighestBidDTO;
//    }
}
