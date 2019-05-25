package com.example.config;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class WebSecurity {

    @Autowired
    private UserService userService;

    public boolean checkUserId(Authentication authentication, int id){
        String name = authentication.getName();
        System.out.println(name + " at " + id);
        User user = userService.get(name);
        return user != null && user.getId() == id;
    }
}
