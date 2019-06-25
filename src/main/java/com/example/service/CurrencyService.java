package com.example.service;

import com.example.model.Currency;

import java.util.List;

public interface CurrencyService {

    Integer save(Currency currency);
    Currency get(Integer id);
    Currency get(String name);
    void update(Integer id, Currency currency);
    void delete(Integer id);
    List<Currency> list();
}
