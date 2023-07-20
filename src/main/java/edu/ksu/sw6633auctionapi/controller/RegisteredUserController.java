package edu.ksu.sw6633auctionapi.controller;
import edu.ksu.sw6633auctionapi.dto.RegisteredUserDTO;
import edu.ksu.sw6633auctionapi.entity.RegisteredUser;
import edu.ksu.sw6633auctionapi.entity.User;
import edu.ksu.sw6633auctionapi.service.RegisteredUserService;
import edu.ksu.sw6633auctionapi.service.UserService;
import org.springframework.data.domain.Page;
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

    @RequestMapping(value = "/getAllRegisteredUser",method = RequestMethod.GET,produces = "application/json")
    public List<RegisteredUserDTO> getAllRegisteredUser(){
        return registeredUserService.getAllRegisteredUser();
    }

    @RequestMapping(value = "/saveRegisteredUser",method = RequestMethod.POST,produces = "application/json")
    public RegisteredUserDTO saveRegisteredUser(@RequestBody RegisteredUserDTO registeredUserDTO){
        User user = userService.loadUserByEmail(registeredUserDTO.getUser().getEmail());
        if (user != null) throw new RuntimeException("Email Already Exist");
        return registeredUserService.createRegisteredUser(registeredUserDTO);
    }

    @RequestMapping(value = "/loadRegisteredUserById/{registeredUserId}",method = RequestMethod.GET,produces = "application/json")
    public RegisteredUser loadRegisteredUserById(@PathVariable Long registeredUserId){
        return registeredUserService.loadRegisteredUserById(registeredUserId);
    }

    @RequestMapping(value = "/findRegisteredUserByEmail",method = RequestMethod.GET,produces = "application/json")
    RegisteredUserDTO findRegisteredUserByEmail(@RequestParam(name = "email", defaultValue = "")String email){
        return registeredUserService.findRegisteredUserByEmail(email);
    }

    @RequestMapping(value = "/findRegisteredUserByName",method = RequestMethod.GET,produces = "application/json")
    public Page<RegisteredUserDTO> findRegisteredUserByName( @RequestParam(name = "name", defaultValue = "")String name,
                                                             @RequestParam(name = "page", defaultValue = "0") int page,
                                                             @RequestParam(name = "size", defaultValue = "5") int size){
        return registeredUserService.findRegisteredUserByName(name,page,size);
    }
}
