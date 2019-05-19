package com.example.service;

import com.example.model.Role;

import java.util.List;

public interface RoleService {

    int save(Role role);
    Role get(int id);
    void update(int id, Role user);
    void delete(int id);
    List<Role> list();
}
