package edu.ksu.sw6633auctionapi.service.impl;

import edu.ksu.sw6633auctionapi.entity.Role;
import edu.ksu.sw6633auctionapi.repository.RoleRepository;
import edu.ksu.sw6633auctionapi.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role createRole(String roleName) {
        return roleRepository.save(new Role(roleName));
    }
}
