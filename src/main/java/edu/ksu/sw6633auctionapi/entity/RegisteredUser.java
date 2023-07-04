package edu.ksu.sw6633auctionapi.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "registeredUser")
public class RegisteredUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registered_user_id", nullable = false)
    private Long registeredUserId;

    @Column(name = "first_name", nullable = false, length = 64)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 64)
    private String lastName;

    @Column(name = "shipping_address", nullable = false, length = 64)
    private String shippingAddress;

    @Column(name = "credit_card_number", nullable = false, length = 64)
    private String creditCardNumber;

    @OneToMany(mappedBy = "registeredUser", fetch = FetchType.LAZY)
    private Set<AuctionItem> auctions = new HashSet<>();

    @OneToMany(mappedBy = "registeredUser", fetch = FetchType.LAZY)
    private Set<Bid> bids = new HashSet<>();

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    public RegisteredUser() {
    }

    public RegisteredUser(String firstName, String lastName, String shippingAddress, String creditCardNumber, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.shippingAddress = shippingAddress;
        this.creditCardNumber = creditCardNumber;
        this.user = user;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RegisteredUser registeredUser = (RegisteredUser) obj;
        return registeredUserId.equals(registeredUser.registeredUserId) && Objects.equals(firstName,registeredUser.firstName)&& Objects.equals(lastName,registeredUser.lastName) && Objects.equals(shippingAddress,registeredUser.shippingAddress)&& Objects.equals(creditCardNumber,registeredUser.creditCardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registeredUserId,firstName,lastName,shippingAddress,creditCardNumber);
    }

    @Override
    public String toString() {
        return "RegisteredUser{" +
                "registeredUserId=" + registeredUserId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", auctions=" + auctions +
                ", bids=" + bids +
                ", user=" + user +
                '}';
    }

    public Long getRegisteredUserId() {
        return registeredUserId;
    }

    public void setRegisteredUserId(Long registeredUserId) {
        this.registeredUserId = registeredUserId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<AuctionItem> getAuctions() {
        return auctions;
    }

    public void setAuctions(Set<AuctionItem> auctions) {
        this.auctions = auctions;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }
}
