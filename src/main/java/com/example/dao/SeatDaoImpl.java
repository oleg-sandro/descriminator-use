package com.example.dao;

import com.example.model.Seat;
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
public class SeatDaoImpl implements SeatDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Integer save(Seat seat) {
        sessionFactory.getCurrentSession().save(seat);
        return seat.getId();
    }

    @Override
    public Seat get(Integer id) {
        return sessionFactory.getCurrentSession().get(Seat.class, id);
    }

    @Override
    public void update(Integer id, Seat seat2) {
        Session session = sessionFactory.getCurrentSession();
        Seat seat1 = session.byId(Seat.class).load(id);
        seat1.setId_hall(seat2.getId_hall());
        seat1.setRow(seat2.getRow());
        session.flush();
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Seat seat = session.byId(Seat.class).load(id);
        session.delete(seat);
    }

    @Override
    public List<Seat> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Seat> cq = cb.createQuery(Seat.class);
        Root<Seat> root = cq.from(Seat.class);
        cq.select(root);
        Query<Seat> query = session.createQuery(cq);
        return query.getResultList();
    }
}
