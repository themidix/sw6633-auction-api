package edu.ksu.sw6633auctionapi.dto;

public class RegisteredUserDTO {

    private Long registeredUserId;
    private String firstName;
    private String lastName;
    private String shippingAddress;
    private String creditCardNumber;

    private UserDTO user;
    private BidDTO bidDTO;

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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public BidDTO getBidDTO() {
        return bidDTO;
    }

    public void setBidDTO(BidDTO bidDTO) {
        this.bidDTO = bidDTO;
    }
}
