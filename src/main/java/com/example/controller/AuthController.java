package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "/index"})
    public String home() {
        System.out.println("GET /index");
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        System.out.println("GET /hello");
        return "hello";
    }

    @GetMapping("/signup")
    public String signUp() {
        System.out.println("GET /signup");
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        System.out.println("POST /signup");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = new User(username, passwordEncoder.encode(password), email);
        user.setId_role(2);
        userService.save(user);
        return "redirect:/login";
    }
}
