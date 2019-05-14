package com.example.dao;

import com.example.entities.User;
import java.util.List;

public interface UserDao {

    Integer save(User user);
    User get(Integer id);
    void update(Integer id, User user);
    void delete(Integer id);
    List<User> list();
}
