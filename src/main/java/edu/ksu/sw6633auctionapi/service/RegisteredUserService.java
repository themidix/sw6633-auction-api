package edu.ksu.sw6633auctionapi.service;

import edu.ksu.sw6633auctionapi.dto.RegisteredUserDTO;
import edu.ksu.sw6633auctionapi.entity.RegisteredUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

public interface RegisteredUserService {

    Page<RegisteredUserDTO> findRegisteredUserByName(String name, int page, int size);
    RegisteredUserDTO findRegisteredUserByEmail(String email);
    RegisteredUser loadRegisteredUserById(Long registeredUserId);
    RegisteredUserDTO createRegisteredUser(RegisteredUserDTO registeredUserDTO);
    RegisteredUserDTO updateRegisteredUser(RegisteredUserDTO registeredUserDTO);
    List<RegisteredUserDTO> getAllRegisteredUser();
    void removeRegisteredUser(Long registeredUserId);
}
