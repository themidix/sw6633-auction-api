package edu.ksu.sw6633auctionapi.service.impl;

import edu.ksu.sw6633auctionapi.dto.GuestUserDTO;
import edu.ksu.sw6633auctionapi.dto.RegisteredUserDTO;
import edu.ksu.sw6633auctionapi.entity.GuestUser;
import edu.ksu.sw6633auctionapi.entity.RegisteredUser;
import edu.ksu.sw6633auctionapi.mapper.GuestUserMapper;
import edu.ksu.sw6633auctionapi.repository.GuestUserRepository;
import edu.ksu.sw6633auctionapi.service.GuestUserService;
import edu.ksu.sw6633auctionapi.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class GuestUserServiceImpl implements GuestUserService {

    private GuestUserRepository guestUserRepository;
    private GuestUserMapper guestUserMapper;
    private UserService userService;

    public GuestUserServiceImpl(GuestUserRepository guestUserRepository, GuestUserMapper guestUserMapper, UserService userService) {
        this.guestUserRepository = guestUserRepository;
        this.guestUserMapper = guestUserMapper;
        this.userService = userService;
    }

    @Override
    public Page<GuestUserDTO> findGuestUserByName(String name, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<GuestUser> guestUserPage = guestUserRepository.findGuestByName(name,pageRequest);
        return new PageImpl<>(guestUserPage.getContent().stream().map(guestUser -> guestUserMapper.fromGuestUser(guestUser)).collect(Collectors.toList()),pageRequest,guestUserPage.getTotalElements());
    }

    @Override
    public RegisteredUserDTO findGuestUserByEmail(String email) {
        return null;
    }

    @Override
    public RegisteredUser loadGuestById(Long registeredUserId) {
        return null;
    }

    @Override
    public RegisteredUserDTO createGuestUser(RegisteredUserDTO registeredUserDTO) {
        return null;
    }

    @Override
    public RegisteredUserDTO updateGuestUser(RegisteredUserDTO registeredUserDTO) {
        return null;
    }

    @Override
    public List<RegisteredUserDTO> getAllGuestUser() {
        return null;
    }

    @Override
    public void removeGuestUser(Long registeredUserId) {

    }
}
