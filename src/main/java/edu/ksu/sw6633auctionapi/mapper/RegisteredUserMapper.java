package edu.ksu.sw6633auctionapi.mapper;

import edu.ksu.sw6633auctionapi.dto.RegisteredUserDTO;
import edu.ksu.sw6633auctionapi.entity.RegisteredUser;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class RegisteredUserMapper {

    public RegisteredUserDTO fromRegisteredUser(RegisteredUser registeredUser){
        RegisteredUserDTO registeredUserDTO = new RegisteredUserDTO();
        BeanUtils.copyProperties(registeredUser,registeredUserDTO);
        return registeredUserDTO;

    }

    public RegisteredUser fromRegisteredDTO(RegisteredUserDTO registeredUserDTO){
        RegisteredUser registeredUser = new RegisteredUser();
        BeanUtils.copyProperties(registeredUserDTO,registeredUser);
        return registeredUser;
    }
}
