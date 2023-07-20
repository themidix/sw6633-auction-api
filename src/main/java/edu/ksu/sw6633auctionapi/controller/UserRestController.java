package edu.ksu.sw6633auctionapi.controller;

import edu.ksu.sw6633auctionapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/checkIfEmailExists",method = RequestMethod.GET,produces = "application/json")
    public boolean checkIfEmailExists(@RequestParam(name = "email", defaultValue = "") String email) {
        return userService.loadUserByEmail(email) != null;
    }

    @RequestMapping(value = "/generateNewAccessToken",method = RequestMethod.GET,produces = "application/json")
    public void generateNewAccessToken(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
