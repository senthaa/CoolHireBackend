package com.javainuse.controller;

import com.javainuse.config.JwtRequestFilter;
import com.javainuse.model.Driver;
import com.javainuse.repository.UserRepository;
import com.javainuse.service.JwtUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;

public class TripController {


    @Autowired
    private UserRepository userRepository;

    @Autowired

    private JwtUserDetailService jwtUserDetailService;

    @Autowired
            private  JwtRequestFilter jwtRequestFilter;

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentPrincipalName = authentication.getName();

    Driver driver = (Driver) jwtUserDetailService.loadUserByUsername(currentPrincipalName);

    UserDetails userDetails = this.jwtUserDetailService.loadUserByUsername(currentPrincipalName);


    @GetMapping("/accept")
    public void acceptTrip(){
       // userRepository.updateState("Driving", driver.getUsername());
    }

    public void startTrip(){

    }

    @GetMapping("/endtrip")
    public void endTrip(){
       // userRepository.updateState("Active", driver.getUsername());
        showPayment();
    }

    public void goOffline(){
//        userRepository.updateState("Offline", driver.getUsername());
    }

    private void showPayment() {

    }
}
