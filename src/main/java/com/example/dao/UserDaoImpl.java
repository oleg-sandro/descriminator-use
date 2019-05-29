package com.example.dao;

import com.example.model.User;

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

    @Override
    public Integer save(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user.getId();
    }

    @Override
    public User get(Integer id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User get(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User u where u.username = :login");
        query.setParameter("login", username);
        return (User) query.getResultList().get(0);
    }

    @Override
    public void update(Integer id, User user2) {
        Session session = sessionFactory.getCurrentSession();
        User user1 = session.byId(User.class).load(id);
        user1.setUsername(user2.getUsername());
        user1.setPassword(user2.getPassword());
        user1.setId_role(user2.getId_role());
        user1.setName(user2.getName());
        user1.setSurname(user2.getSurname());
        user1.setEmail(user2.getEmail());
        user1.setBirth(user2.getBirth());
        session.flush();
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.byId(User.class).load(id);
        session.delete(user);
    }

    @Override
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
