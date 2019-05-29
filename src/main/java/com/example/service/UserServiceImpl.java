package com.example.service;

import com.example.dao.UserDao;
import com.example.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public Integer save(User user) {
        return userDao.save(user);
    }

    @Override
    public User get(Integer id) {
        return userDao.get(id);
    }

    @Override
    public User get(String username) {
        return userDao.get(username);
    }

    @Override
    @Transactional
    public void update(Integer id, User user) {
        userDao.update(id, user);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public List<User> list() {
        return userDao.list();
    }
}
