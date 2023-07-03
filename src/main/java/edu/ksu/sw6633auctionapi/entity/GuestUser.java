package edu.ksu.sw6633auctionapi.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name ="customer")
public class GuestUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guest_user_id", nullable = false)
    private Long guestUserId;

    @Column(name = "first_name", nullable = false, length = 64, unique = true)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 64, unique = true)
    private String lastName;
    @Column(name = "shipping_address", nullable = false, length = 64, unique = true)
    private String shippingAddress;
    @Column(name = "credit_card_number", nullable = false, length = 64, unique = true)
    private String creditCardNumber;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    public GuestUser() {
    }

    public GuestUser(String firstName, String lastName, String shippingAddress, String creditCardNumber, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.shippingAddress = shippingAddress;
        this.creditCardNumber = creditCardNumber;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GuestUser)) return false;
        GuestUser guestUser = (GuestUser) o;
        return Objects.equals(getGuestUserId(), guestUser.getGuestUserId()) && Objects.equals(getFirstName(), guestUser.getFirstName()) && Objects.equals(getLastName(), guestUser.getLastName()) && Objects.equals(getShippingAddress(), guestUser.getShippingAddress()) && Objects.equals(getCreditCardNumber(), guestUser.getCreditCardNumber()) && Objects.equals(getUser(), guestUser.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGuestUserId(), getFirstName(), getLastName(), getShippingAddress(), getCreditCardNumber(), getUser());
    }

    @Override
    public String toString() {
        return "GuestUser{" +
                "guestUserId=" + guestUserId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", user=" + user +
                '}';
    }

    public Long getGuestUserId() {
        return guestUserId;
    }

    public void setGuestUserId(Long guestUserId) {
        this.guestUserId = guestUserId;
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
}
