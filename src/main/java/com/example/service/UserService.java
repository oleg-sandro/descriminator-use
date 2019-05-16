package com.example.service;

import com.example.entities.User;

import java.util.List;

public interface UserService {

    int save(User user);
    User get(int id);
    void update(int id, User user);
    void delete(int id);
    List<User> list();
}
