package com.example.service;

import com.example.entities.User;

import java.util.List;

public interface UserService {

    Integer save(User user);
    User get(Integer id);
    List<User> list();
    void update(Integer id, User user);
    void delete(Integer id);
}
