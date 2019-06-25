package com.example.dao;

import com.example.model.Payments;

import java.util.List;

public interface PaymentsDao {

    Integer save(Payments payments);
    List<Payments> get(Integer id_user);
    void update(Integer id, Payments payments);
    void delete(Integer id);
    List<Payments> list();
}
