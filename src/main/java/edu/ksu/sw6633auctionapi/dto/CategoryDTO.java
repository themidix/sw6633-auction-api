package edu.ksu.sw6633auctionapi.dto;

public class CategoryDTO {
    private Long categoryId;
    private String categoryName;

    private AuctionItemDTO auctionItemDTO;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public AuctionItemDTO getAuctionItemDTO() {
        return auctionItemDTO;
    }

    public void setAuctionItemDTO(AuctionItemDTO auctionItemDTO) {
        this.auctionItemDTO = auctionItemDTO;
    }
}
