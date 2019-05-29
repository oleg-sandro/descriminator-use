package com.example.service;

import com.example.model.Ticket;

import java.util.List;

public interface TicketService {

    Integer save(Ticket ticket);
    Ticket get(Integer id);
    void update(Integer id, Ticket ticket);
    void delete(Integer id);
    List<Ticket> list();
}
