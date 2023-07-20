package edu.ksu.sw6633auctionapi.mapper;

import edu.ksu.sw6633auctionapi.dto.GuestUserDTO;
import edu.ksu.sw6633auctionapi.entity.GuestUser;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
@Service
public class GuestUserMapper {
    public GuestUserDTO fromGuestUser(GuestUser guestUser){
        GuestUserDTO guestUserDTO = new GuestUserDTO();
        BeanUtils.copyProperties(guestUser,guestUserDTO);
        return guestUserDTO;
    }
    public GuestUser fromGuestUserDTO(GuestUserDTO guestUserDTO){
        GuestUser guestUser = new GuestUser();
        BeanUtils.copyProperties(guestUserDTO,guestUser);
        return guestUser;
    }
}
