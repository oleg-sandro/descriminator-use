package com.example.dao;

import com.example.model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TicketDaoImpl implements TicketDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Integer save(Ticket ticket) {
        sessionFactory.getCurrentSession().save(ticket);
        return ticket.getId();
    }

    @Override
    public Ticket get(Integer id) {
        return sessionFactory.getCurrentSession().get(Ticket.class, id);
    }

    @Override
    public void update(Integer id, Ticket ticket2) {
        Session session = sessionFactory.getCurrentSession();
        Ticket ticket1 = session.byId(Ticket.class).load(id);
        ticket1.setId_user(ticket2.getId_user());
        ticket1.setId_show(ticket2.getId_show());
        ticket1.setId_seat(ticket2.getId_seat());
        session.flush();
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Ticket ticket = session.byId(Ticket.class).load(id);
        session.delete(ticket);
    }

    @Override
    public List<Ticket> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Ticket> cq = cb.createQuery(Ticket.class);
        Root<Ticket> root = cq.from(Ticket.class);
        cq.select(root);
        Query<Ticket> query = session.createQuery(cq);
        return query.getResultList();
    }
}
