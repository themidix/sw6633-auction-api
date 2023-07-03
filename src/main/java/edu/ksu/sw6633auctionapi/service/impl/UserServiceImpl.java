package edu.ksu.sw6633auctionapi.service.impl;

import edu.ksu.sw6633auctionapi.entity.Role;
import edu.ksu.sw6633auctionapi.entity.User;
import edu.ksu.sw6633auctionapi.repository.RoleRepository;
import edu.ksu.sw6633auctionapi.repository.UserRepository;
import edu.ksu.sw6633auctionapi.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    //    private PasswordEncoder passwordEncoder;
    @Override
    public User loadUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User createUser(String email, String password) {
        return userRepository.save(new User(email,password));
    }

    @Override
    public void assignRoleToUser(String email, String roleName) {
        User user = loadUserByEmail(email);
        Role role = roleRepository.findByName(roleName);
        user.assignRoleToUser(role);
    }
}
