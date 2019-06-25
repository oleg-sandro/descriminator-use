package com.example.service;

import com.example.dao.AccountDao;
import com.example.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional
    public Integer save(Account account) {
        return accountDao.save(account);
    }

    @Override
    public List<Account> get(Integer id_user) {
        return accountDao.get(id_user);
    }

    @Override
    @Transactional
    public void update(Integer id, Account account) {
        accountDao.update(id, account);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        accountDao.delete(id);
    }

    @Override
    public List<Account> list() {
        return accountDao.list();
    }
}
