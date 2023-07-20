package edu.ksu.sw6633auctionapi.service;

import edu.ksu.sw6633auctionapi.dto.GuestUserDTO;
import edu.ksu.sw6633auctionapi.dto.RegisteredUserDTO;
import edu.ksu.sw6633auctionapi.entity.RegisteredUser;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GuestUserService {

    Page<GuestUserDTO> findGuestUserByName(String name, int page, int size);
    RegisteredUserDTO findGuestUserByEmail(String email);
    RegisteredUser loadGuestById(Long registeredUserId);
    RegisteredUserDTO createGuestUser(RegisteredUserDTO registeredUserDTO);
    RegisteredUserDTO updateGuestUser(RegisteredUserDTO registeredUserDTO);
    List<RegisteredUserDTO> getAllGuestUser();
    void removeGuestUser(Long registeredUserId);
}
