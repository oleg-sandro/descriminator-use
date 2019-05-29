package com.example.dao;

import com.example.model.Role;

import java.util.List;

public interface RoleDao {

    Integer save(Role role);
    Role get(Integer id);
    Role get(String name);
    void update(Integer id, Role role);
    void delete(Integer id);
    List<Role> list();
}
