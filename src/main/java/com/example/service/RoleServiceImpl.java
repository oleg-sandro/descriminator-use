package com.example.service;

import com.example.dao.RoleDao;
import com.example.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Transactional
    public int save(Role role) {
        return roleDao.save(role);
    }

    public Role get(int id) {
        return roleDao.get(id);
    }

    @Transactional
    public void update(int id, Role role) {
        roleDao.update(id, role);
    }

    @Transactional
    public void delete(int id) {
        roleDao.delete(id);
    }

    public List<Role> list() {
        return roleDao.list();
    }
}
