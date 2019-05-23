package com.example.controller;

import com.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.atomic.AtomicLong;

/**
 * This class was created for testing of Tomcat's successful launch
 */
@Controller
@RequestMapping("/work")
public class TestController {

    private AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printSomething() {
        System.out.println("It's a counter processing.");
        return String.valueOf(counter.incrementAndGet());
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        System.out.println("It's a home processing.");
        return "home";
    }

    @RequestMapping(value = "/output", method = RequestMethod.GET)
    public String output() {
        System.out.println("It's a output processing.");
        return "output";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        System.out.println("It's a login processing.");
        return "login";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String login(@RequestParam(name = "error", required = false) Boolean error, Model model) {
        System.out.println("It's a reg processing.");
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", true);
        }
        return "reg";
    }

    /*@RequestMapping("/login")
    public ModelAndView login() {
        User user = new User();
        user.setLogin("superuser");
        user.setPassword("124567890");
        user.setId_role(2);
        return new ModelAndView("login", "login", user);
        //return new ModelAndView("login");
    }*/
}
