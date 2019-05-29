package com.example.dao;

import com.example.model.Hall;
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
public class HallDaoImpl implements HallDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Integer save(Hall hall) {
        sessionFactory.getCurrentSession().save(hall);
        return hall.getId();
    }

    @Override
    public Hall get(Integer id) {
        return sessionFactory.getCurrentSession().get(Hall.class, id);
    }

    @Override
    public Hall get(String number) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Hall h where h.number = :number");
        query.setParameter("number", number);
        return (Hall) query.getResultList().get(0);
    }

    @Override
    public void update(Integer id, Hall hall2) {
        Session session = sessionFactory.getCurrentSession();
        Hall hall1 = session.byId(Hall.class).load(id);
        hall1.setNumber(hall2.getNumber());
        hall1.setRows(hall2.getRows());
        hall1.setCols(hall2.getCols());
        hall1.setDescription(hall2.getDescription());
        session.flush();
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Hall hall = session.byId(Hall.class).load(id);
        session.delete(hall);
    }

    @Override
    public List<Hall> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Hall> cq = cb.createQuery(Hall.class);
        Root<Hall> root = cq.from(Hall.class);
        cq.select(root);
        Query<Hall> query = session.createQuery(cq);
        return query.getResultList();
    }
}
