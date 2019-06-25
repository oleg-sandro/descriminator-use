package com.example.service;

import com.example.model.Account;

import java.util.List;

public interface AccountService {

    Integer save(Account account);
    List<Account> get(Integer id_user);
    void update(Integer id, Account account);
    void delete(Integer id);
    List<Account> list();
}
