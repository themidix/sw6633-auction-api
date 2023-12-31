package edu.ksu.sw6633auctionapi.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="Auction_items")
public class AuctionItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auction_item_item_id", nullable = false)
    private Long auctionItemId;
    @Column(name = "auction_item_img_url",length = 100)
    private String auctionItmImgUrl;
    @Column(name = "description", length = 64)
    private String description;
    @Column(name = "starting_price", nullable = false, length = 64)
    private double startingPrice;

    @Column(name = "auction_item_status", nullable = false, length = 45)
    private boolean auctionItemStatus;

    @Column(nullable = true)
    private LocalDateTime closingTime;

    @Column(nullable = true)
    @Temporal("")
    private LocalDateTime createdAt;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "bid_id")
    private Bid currentHighestBid;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "registered_user_id",referencedColumnName = "registered_user_id")
    private RegisteredUser registeredUser;

    public AuctionItem() {
    }

    public AuctionItem(String auctionItmImgUrl, String description, double startingPrice, boolean auctionItemStatus, LocalDateTime closingTime, LocalDateTime createdAt, Category category, Bid currentHighestBid, RegisteredUser registeredUser) {
        this.auctionItmImgUrl = auctionItmImgUrl;
        this.description = description;
        this.startingPrice = startingPrice;
        this.auctionItemStatus = auctionItemStatus;
        this.closingTime = closingTime;
        this.createdAt = createdAt;
        this.category = category;
        this.currentHighestBid = currentHighestBid;
        this.registeredUser = registeredUser;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuctionItem)) return false;
        AuctionItem that = (AuctionItem) o;
        return Double.compare(that.startingPrice, startingPrice) == 0 && auctionItemStatus == that.auctionItemStatus && Objects.equals(auctionItemId, that.auctionItemId) && Objects.equals(auctionItmImgUrl, that.auctionItmImgUrl) && Objects.equals(description, that.description) && Objects.equals(closingTime, that.closingTime) && Objects.equals(createdAt, that.createdAt) && Objects.equals(category, that.category) && Objects.equals(currentHighestBid, that.currentHighestBid) && Objects.equals(registeredUser, that.registeredUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(auctionItemId, auctionItmImgUrl, description, startingPrice, closingTime, createdAt, category, auctionItemStatus, currentHighestBid, registeredUser);
    }

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

    public LocalDateTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalDateTime closingTime) {
        this.closingTime = closingTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isAuctionItemStatus() {
        return auctionItemStatus;
    }

    public void setAuctionItemStatus(boolean auctionItemStatus) {
        this.auctionItemStatus = auctionItemStatus;
    }

    public Bid getCurrentHighestBid() {
        return currentHighestBid;
    }

    public void setCurrentHighestBid(Bid currentHighestBid) {
        this.currentHighestBid = currentHighestBid;
    }

    public RegisteredUser getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(RegisteredUser registeredUser) {
        this.registeredUser = registeredUser;
    }
}
