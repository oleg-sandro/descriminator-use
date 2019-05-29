package com.example.service;

import com.example.model.Hall;

import java.util.List;

public interface HallService {

    Integer save(Hall hall);
    Hall get(Integer id);
    Hall get(String number);
    void update(Integer id, Hall hall);
    void delete(Integer id);
    List<Hall> list();
}
