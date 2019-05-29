package com.example.service;

import com.example.model.User;

import java.util.List;

public interface UserService {

    Integer save(User user);
    User get(Integer id);
    User get(String username);
    void update(Integer id, User user);
    void delete(Integer id);
    List<User> list();
}
