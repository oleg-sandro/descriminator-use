package com.example.service;

import com.example.model.Role;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        User user = userService.get(login);
        if(user != null){
            Role role = roleService.get(user.getId_role());

            Set<GrantedAuthority> roles = new HashSet();
            roles.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));

            UserDetails userDetails = new org.springframework.security.core.userdetails
                    .User(user.getLogin(), user.getPassword(), roles);
            return userDetails;
        }
        return null;
    }
}
