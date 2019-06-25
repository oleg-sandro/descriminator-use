package com.example.config;

import com.example.model.Account;
import com.example.model.User;
import com.example.service.AccountService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WebSecurity {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    public boolean checkUserId(Authentication authentication, int id){
        String name = authentication.getName();
        User user = userService.get(name);
        return user != null && user.getId() == id;
    }
}
