package edu.ksu.sw6633auctionapi.service;

import edu.ksu.sw6633auctionapi.entity.User;

public interface UserService {

    User loadUserByEmail(String email);

    User createUser(String email, String password);

    void assignRoleToUser(String email, String roleName);
}
