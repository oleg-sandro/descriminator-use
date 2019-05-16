package com.example.dao;

import com.example.entities.User;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    public int save(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user.getId();
    }

    public User get(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    public void update(int id, User user2) {
        Session session = sessionFactory.getCurrentSession();
        User  user1 = session.byId(User.class).load(id);
        user1.setLogin(user2.getLogin());
        user1.setPassword(user2.getPassword());
        user1.setId_role(user2.getId_role());
        session.flush();
    }

        public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.byId(User.class).load(id);
        session.delete(user);
    }

    public List<User> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        Query<User> query = session.createQuery(cq);
        return query.getResultList();
    }
}
