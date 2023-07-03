package edu.ksu.sw6633auctionapi.dto;

public class GuestUserDTO {
    private Long guestUserId;
    private String firstName;
    private String lastName;
    private String shippingAddress;
    private String creditCardNumber;
    private UserDTO user;

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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
