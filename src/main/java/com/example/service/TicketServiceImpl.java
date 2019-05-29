package com.example.service;

import com.example.dao.TicketDao;
import com.example.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDao ticketDao;

    @Override
    @Transactional
    public Integer save(Ticket ticket) {
        return ticketDao.save(ticket);
    }

    @Override
    public Ticket get(Integer id) {
        return ticketDao.get(id);
    }

    @Override
    @Transactional
    public void update(Integer id, Ticket ticket) {
        ticketDao.update(id, ticket);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        ticketDao.delete(id);
    }

    @Override
    public List<Ticket> list() {
        return ticketDao.list();
    }
}
