package com.javainuse.controller;
import com.javainuse.model.Driver;
import com.javainuse.repository.UserRepository;
import com.javainuse.service.JwtUserDetailService;
import com.javainuse.service.SecurityServiceImpl;
import com.javainuse.service.Securityservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
public class SignUpController {

    @Autowired
    UserRepository repository;

    @Autowired
    SecurityServiceImpl security;

    @Autowired

    private JwtUserDetailService jwtUserDetailsService;

//    @GetMapping("/signup")
//    public String registration(Model model) {
//        model.addAttribute("userForm", new Driver());
//
//        return "signup";
//    }

    @GetMapping("/signup")

    public String create(@RequestParam String username, @RequestParam String password) {

        repository.save(new Driver(username, new BCryptPasswordEncoder().encode( password)));

       // securityservice.autoLogin(username, password);

        return "Registered";
        //return "redirect:/welcome";
    }

//    public String create(@RequestParam String username, @RequestParam String password){
//
//        if(Objects.isNull(repository.findByUsername(username))){
//            repository.save(new Driver(username, password));
//            return "Driver" + username + " is created";
//            Securityservice.autoLogin(u.getUsername(), userForm.getPasswordConfirm());
//        }
//        else{
//            return "User already exist";
//        }
//    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        security.autoLogin(username, password);

        return "login";
    }
}
