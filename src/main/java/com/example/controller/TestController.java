package com.example.controller;

import com.example.model.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.atomic.AtomicLong;

/**
 * This class was created for testing of Tomcat's successful launch
 */
@RestController
public class TestController {

    /*private AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public long printSomething() {
        return counter.incrementAndGet();
    }*/

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        User user = new User();
        user.setLogin("superuser");
        user.setPassword("124567890");
        user.setId_role(2);
        return new ModelAndView("login", "login", user);
        //return new ModelAndView("login");
    }
}
