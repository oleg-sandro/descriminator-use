package com.example.dao;

import com.example.model.Payments;
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
public class PaymentsDaoImpl implements PaymentsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Integer save(Payments payments) {
        sessionFactory.getCurrentSession().save(payments);
        return payments.getId();
    }

    @Override
    public List<Payments> get(Integer id_user) {
        // Without Criteria API using, mb need to redo
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT p FROM Payments AS p JOIN Account AS a ON p.id_account = a.id WHERE a.id_user=" + id_user;
        Query query = session.createQuery(hql);
        return query.list();
    }

    @Override
    public void update(Integer id, Payments payments2) {
        Session session = sessionFactory.getCurrentSession();
        Payments payments1 = session.byId(Payments.class).load(id);
        payments1.setId_ticket(payments2.getId_ticket());
        payments1.setId_account(payments2.getId_account());
        payments1.setAmount(payments2.getAmount());
        payments1.setId_currency(payments2.getId_currency());
        payments1.setOperation_date(payments2.getOperation_date());
        session.flush();
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Payments payments = session.byId(Payments.class).load(id);
        session.delete(payments);
    }

    @Override
    public List<Payments> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Payments> cq = cb.createQuery(Payments.class);
        Root<Payments> root = cq.from(Payments.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }
}
