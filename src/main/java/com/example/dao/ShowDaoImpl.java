package com.example.dao;

import com.example.model.Show;
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
public class ShowDaoImpl implements ShowDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Integer save(Show show) {
        sessionFactory.getCurrentSession().save(show);
        return show.getId();
    }

    @Override
    public Show get(Integer id) {
        return sessionFactory.getCurrentSession().get(Show.class, id);
    }

    @Override
    public void update(Integer id, Show show2) {
        Session session = sessionFactory.getCurrentSession();
        Show show1 = session.byId(Show.class).load(id);
        show1.setId_film(show2.getId_film());
        show1.setWhen_start(show2.getWhen_start());
        show1.setId_hall(show2.getId_hall());
        session.flush();
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Show show = session.byId(Show.class).load(id);
        session.delete(show);
    }

    @Override
    public List<Show> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Show> cq = cb.createQuery(Show.class);
        Root<Show> root = cq.from(Show.class);
        cq.select(root);
        Query<Show> query = session.createQuery(cq);
        return query.getResultList();
    }
}
