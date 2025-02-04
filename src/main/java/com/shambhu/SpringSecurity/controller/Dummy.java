package com.shambhu.SpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dummy {
    @GetMapping("/")
    public String hello(){
        return "Welcome to Spring security...";
    }
}
