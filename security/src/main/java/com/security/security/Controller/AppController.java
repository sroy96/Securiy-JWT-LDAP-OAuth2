package com.security.security.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AppController {

    @GetMapping("/")
    public String all(){
        return "For ALL";
    }
    @GetMapping("/user")
    public String forUser(){
        return " USER login ";
    }

    @GetMapping("/admin")
    public String forAdmin(){
        return "admin";
    }

}
