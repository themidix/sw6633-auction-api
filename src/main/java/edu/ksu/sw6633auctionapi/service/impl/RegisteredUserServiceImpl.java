package edu.ksu.sw6633auctionapi.service.impl;

import edu.ksu.sw6633auctionapi.dto.RegisteredUserDTO;
import edu.ksu.sw6633auctionapi.entity.RegisteredUser;
import edu.ksu.sw6633auctionapi.entity.User;
import edu.ksu.sw6633auctionapi.mapper.RegisteredUserMapper;
import edu.ksu.sw6633auctionapi.repository.RegisteredUserRepository;
import edu.ksu.sw6633auctionapi.service.RegisteredUserService;
import edu.ksu.sw6633auctionapi.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RegisteredUserServiceImpl implements RegisteredUserService {

    private RegisteredUserRepository registeredUserRepository;
    private RegisteredUserMapper registeredUserMapper;

    private UserService userService;

    public RegisteredUserServiceImpl(RegisteredUserMapper registeredUserMapper, RegisteredUserRepository registeredUserRepository, UserService userService) {
        this.registeredUserMapper = registeredUserMapper;
        this.registeredUserRepository = registeredUserRepository;
        this.userService = userService;
    }
    @Override
    public Page<RegisteredUserDTO> findRegisteredUserByName(String name, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<RegisteredUser> registeredUserPage = registeredUserRepository.findRegisteredUserByName(name,pageRequest);
        return new PageImpl<>(registeredUserPage.getContent().stream().map(registeredUser -> registeredUserMapper.fromRegisteredUser(registeredUser)).collect(Collectors.toList()),pageRequest,registeredUserPage.getTotalElements());
    }
    @Override
    public RegisteredUserDTO findRegisteredUserByEmail(String email) {
        return registeredUserMapper.fromRegisteredUser(registeredUserRepository.findRegisteredUserByEmail(email));
    }
    @Override
    public RegisteredUser loadRegisteredUserById(Long registeredUserId) {
        return registeredUserRepository.findById(registeredUserId).orElseThrow(()-> new EntityNotFoundException("RegisterUser with ID" + registeredUserId + "does not exist."));
    }

    @Override
    public RegisteredUserDTO createRegisteredUser(RegisteredUserDTO registeredUserDTO) {
        User user = userService.createUser(registeredUserDTO.getUser().getEmail(),registeredUserDTO.getUser().getPassword());
        userService.assignRoleToUser(registeredUserDTO.getUser().getEmail(),"RegisteredUser");
        RegisteredUser registeredUser = registeredUserMapper.fromRegisteredDTO(registeredUserDTO);
        registeredUser.setUser(user);
        RegisteredUser savedRegisteredUser = registeredUserRepository.save(registeredUser);
        return registeredUserMapper.fromRegisteredUser(savedRegisteredUser);

    }

    @Override
    public RegisteredUserDTO updateRegisteredUser(RegisteredUserDTO registeredUserDTO) {
        RegisteredUser loadedRegisteredUser = loadRegisteredUserById(registeredUserDTO.getRegisteredUserId());
        RegisteredUser registeredUser = registeredUserMapper.fromRegisteredDTO(registeredUserDTO);
        registeredUser.setUser(loadedRegisteredUser.getUser());
        //set Auction here
        RegisteredUser updatedRegisterUser = registeredUserRepository.save(registeredUser);
        return registeredUserMapper.fromRegisteredUser(updatedRegisterUser);
    }

    @Override
    public List<RegisteredUserDTO> getAllRegisteredUser() {
        return registeredUserRepository.findAll().
                                         stream().
                                            map(registeredUser -> registeredUserMapper.fromRegisteredUser(registeredUser)).collect(Collectors.toList());
    }

    @Override
    public void removeRegisteredUser(Long registeredUserId) {
        registeredUserRepository.deleteById(registeredUserId);
    }
}
