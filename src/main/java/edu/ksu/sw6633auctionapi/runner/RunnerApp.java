package edu.ksu.sw6633auctionapi.runner;

import edu.ksu.sw6633auctionapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RunnerApp implements CommandLineRunner {

    @Autowired
    private RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        createRoles();
    }
    private void createRoles() {
        Arrays.asList("Admin", "RegisteredUser", "GuestUser").forEach(role -> roleService.createRole(role));
    }
}
