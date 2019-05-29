package com.example.service;

import com.example.dao.RoleDao;
import com.example.model.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional
    public Integer save(Role role) {
        return roleDao.save(role);
    }

    @Override
    public Role get(Integer id) {
        return roleDao.get(id);
    }

    @Override
    public Role get(String name) {
        return roleDao.get(name);
    }

    @Override
    @Transactional
    public void update(Integer id, Role role) {
        roleDao.update(id, role);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        roleDao.delete(id);
    }

    @Override
    public List<Role> list() {
        return roleDao.list();
    }
}
