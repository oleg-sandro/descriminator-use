package com.example.service;

import com.example.dao.UserDao;
import com.example.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Transactional
    public Integer save(User user) {
        return userDao.save(user);
    }

    public User get(Integer id) {
        return userDao.get(id);
    }

    public List<User> list() {
        return userDao.list();
    }

    @Transactional
    public void update(Integer id, User user) {
        userDao.update(id, user);
    }

    @Transactional
    public void delete(Integer id) {
        userDao.delete(id);
    }
}
