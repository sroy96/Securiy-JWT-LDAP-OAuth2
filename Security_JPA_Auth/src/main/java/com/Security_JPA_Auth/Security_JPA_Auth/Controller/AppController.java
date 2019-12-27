package com.Security_JPA_Auth.Security_JPA_Auth.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AppController {

    @GetMapping("/")
    public String all(){
        return "WELCOME";
    }
    @GetMapping("/user")
    public String forUser(){
        return " WELCOME USER ";
    }

    @GetMapping("/admin")
    public String forAdmin(){
        return "WELCOME ADMIN";
    }

}