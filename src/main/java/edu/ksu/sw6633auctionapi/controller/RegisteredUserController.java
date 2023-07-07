package edu.ksu.sw6633auctionapi.controller;
import edu.ksu.sw6633auctionapi.dto.RegisteredUserDTO;
import edu.ksu.sw6633auctionapi.entity.RegisteredUser;
import edu.ksu.sw6633auctionapi.entity.User;
import edu.ksu.sw6633auctionapi.service.RegisteredUserService;
import edu.ksu.sw6633auctionapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registeredUsers")
@CrossOrigin("*")
public class RegisteredUserController {

    RegisteredUserService registeredUserService;
    private UserService userService;

    public RegisteredUserController( RegisteredUserService registeredUserService, UserService userService) {
        this.registeredUserService = registeredUserService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<RegisteredUserDTO> getAllRegisteredUser(){
        return registeredUserService.getAllRegisteredUser();
    }

    @PostMapping
    public RegisteredUserDTO saveRegisteredUser(@RequestBody RegisteredUserDTO registeredUserDTO){
        User user = userService.loadUserByEmail(registeredUserDTO.getUser().getEmail());
        if (user != null) throw new RuntimeException("Email Already Exist");
        return registeredUserService.createRegisteredUser(registeredUserDTO);
    }

    @GetMapping("/{registeredUserId}")
    public RegisteredUser loadRegisteredUserById(@PathVariable Long registeredUserId){
        return registeredUserService.loadRegisteredUserById(registeredUserId);
    }

    @GetMapping
    RegisteredUserDTO findRegisteredUserByEmail(@RequestParam(name = "email", defaultValue = "")String email){
        return registeredUserService.findRegisteredUserByEmail(email);
    }
}
