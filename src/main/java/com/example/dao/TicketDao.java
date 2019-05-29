package com.example.dao;

import com.example.model.Ticket;

import java.util.List;

public interface TicketDao {

    Integer save(Ticket ticket);
    Ticket get(Integer id);
    void update(Integer id, Ticket ticket);
    void delete(Integer id);
    List<Ticket> list();
}
