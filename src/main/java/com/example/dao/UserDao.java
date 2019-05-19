package com.example.dao;

import com.example.model.User;
import java.util.List;

public interface UserDao {

    int save(User user);
    User get(int id);
    void update(int id, User user);
    void delete(int id);
    List<User> list();
}
