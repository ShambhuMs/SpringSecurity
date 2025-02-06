package com.shambhu.SpringSecurity.controller;

import com.shambhu.SpringSecurity.dto.Users;
import com.shambhu.SpringSecurity.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return myUserDetailsService.register(user);
    }
}
