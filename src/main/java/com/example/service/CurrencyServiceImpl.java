package com.example.service;

import com.example.dao.CurrencyDao;
import com.example.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyDao currencyDao;

    @Override
    @Transactional
    public Integer save(Currency currency) {
        return currencyDao.save(currency);
    }

    @Override
    public Currency get(Integer id) {
        return currencyDao.get(id);
    }

    @Override
    public Currency get(String name) {
        return currencyDao.get(name);
    }

    @Override
    @Transactional
    public void update(Integer id, Currency currency) {
        currencyDao.update(id, currency);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        currencyDao.delete(id);
    }

    @Override
    public List<Currency> list() {
        return currencyDao.list();
    }
}
