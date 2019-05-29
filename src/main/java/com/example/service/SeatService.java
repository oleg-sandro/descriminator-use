package com.example.service;

import com.example.model.Seat;

import java.util.List;

public interface SeatService {

    Integer save(Seat seat);
    Seat get(Integer id);
    void update(Integer id, Seat seat);
    void delete(Integer id);
    List<Seat> list();
}
