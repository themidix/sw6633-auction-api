package edu.ksu.sw6633auctionapi.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name ="bid")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "bid_id", nullable = false)
    private Long bidId;
    @Column(name = "comment", nullable = false, length = 64)
    private String comment;
    @Column(name = "amount", nullable = false, length = 45)
    private double amount;
    @Column(nullable = false)
    private LocalDateTime placedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auction_item_id",referencedColumnName = "registered_user_id")
    private AuctionItem auctionItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registered_user_id",referencedColumnName = "registered_user_id")
    private RegisteredUser registeredUser;

    public Bid(GuestUser placedBy, String comment, double amount, LocalDateTime placedAt, AuctionItem auctionItem, RegisteredUser registeredUser) {
        this.comment = comment;
        this.amount = amount;
        this.placedAt = placedAt;
        this.auctionItem = auctionItem;
        this.registeredUser = registeredUser;
    }
    public Bid() {

    }

    public Bid(String comment, double amount, LocalDateTime placedAt, AuctionItem auctionItem) {
        this.comment = comment;
        this.amount = amount;
        this.placedAt = placedAt;
        this.auctionItem = auctionItem;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "bidId=" + bidId +
                ", comment='" + comment + '\'' +
                ", amount=" + amount +
                ", placedAt=" + placedAt +
                ", auctionItem=" + auctionItem +
                ", registeredUser=" + registeredUser +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bid)) return false;
        Bid bid = (Bid) o;
        return Double.compare(bid.amount, amount) == 0 && Objects.equals(bidId, bid.bidId) && Objects.equals(comment, bid.comment) && Objects.equals(placedAt, bid.placedAt) && Objects.equals(auctionItem, bid.auctionItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bidId, comment, amount, placedAt, auctionItem);
    }

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

    public AuctionItem getAuctionItem() {
        return auctionItem;
    }

    public void setAuctionItem(AuctionItem auctionItem) {
        this.auctionItem = auctionItem;
    }

    public RegisteredUser getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(RegisteredUser registeredUser) {
        this.registeredUser = registeredUser;
    }
}
