package com.example.dao;

import com.example.model.Film;
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
public class FilmDaoImpl implements FilmDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Integer save(Film film) {
        sessionFactory.getCurrentSession().save(film);
        return film.getId();
    }

    @Override
    public Film get(Integer id) {
        return sessionFactory.getCurrentSession().get(Film.class, id);
    }

    @Override
    public void update(Integer id, Film film2) {
        Session session = sessionFactory.getCurrentSession();
        Film film1 = session.byId(Film.class).load(id);
        film1.setTitle(film2.getTitle());
        film1.setYear(film2.getYear());
        film1.setCountry(film2.getCountry());
        film1.setProducer(film2.getProducer());
        film1.setGenre(film2.getGenre());
        film1.setDuration(film2.getDuration());
        film1.setDescription(film2.getDescription());
        film1.setWhen_start(film2.getWhen_start());
        film1.setWhen_finish(film2.getWhen_finish());
        session.flush();
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Film film = session.byId(Film.class).load(id);
        session.delete(film);
    }

    @Override
    public List<Film> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Film> cq = cb.createQuery(Film.class);
        Root<Film> root = cq.from(Film.class);
        cq.select(root);
        Query<Film> query = session.createQuery(cq);
        return query.getResultList();
    }
}
