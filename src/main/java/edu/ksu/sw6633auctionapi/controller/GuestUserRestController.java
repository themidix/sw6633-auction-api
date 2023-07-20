package edu.ksu.sw6633auctionapi.controller;

import edu.ksu.sw6633auctionapi.service.GuestUserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guestUsers")
@CrossOrigin("*")
public class GuestUserRestController {

    private GuestUserService guestUserService;

    public GuestUserRestController(GuestUserService guestUserService) {
        this.guestUserService = guestUserService;
    }
}
