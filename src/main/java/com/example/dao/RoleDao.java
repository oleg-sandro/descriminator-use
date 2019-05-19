package com.example.dao;

import com.example.model.Role;

import java.util.List;

public interface RoleDao {

    int save(Role role);
    Role get(int id);
    void update(int id, Role role);
    void delete(int id);
    List<Role> list();
}
