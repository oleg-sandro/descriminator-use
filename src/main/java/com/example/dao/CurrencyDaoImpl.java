package com.example.dao;

import com.example.model.Currency;
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
public class CurrencyDaoImpl implements CurrencyDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Integer save(Currency currency) {
        sessionFactory.getCurrentSession().save(currency);
        return currency.getId();
    }

    @Override
    public Currency get(Integer id) {
        return sessionFactory.getCurrentSession().get(Currency.class, id);
    }

    @Override
    public Currency get(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Currency c where c.name = :name");
        query.setParameter("name", name);
        return (Currency) query.getResultList().get(0);
    }

    @Override
    public void update(Integer id, Currency currency2) {
        Session session = sessionFactory.getCurrentSession();
        Currency currency1 = session.byId(Currency.class).load(id);
        currency1.setName(currency2.getName());
        currency1.setExt_id(currency2.getExt_id());
        session.flush();
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Currency currency = session.byId(Currency.class).load(id);
        session.delete(currency);
    }

    @Override
    public List<Currency> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Currency> cq = cb.createQuery(Currency.class);
        Root<Currency> root = cq.from(Currency.class);
        cq.select(root);
        Query<Currency> query = session.createQuery(cq);
        return query.getResultList();
    }
}
