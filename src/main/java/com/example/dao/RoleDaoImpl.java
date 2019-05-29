package com.example.dao;

import com.example.model.Role;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Integer save(Role role) {
        sessionFactory.getCurrentSession().save(role);
        return role.getId();
    }

    @Override
    public Role get(Integer id) {
        return sessionFactory.getCurrentSession().get(Role.class, id);
    }

    @Override
    public Role get(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Role r where r.name = :name");
        query.setParameter("name", name);
        return (Role) query.getResultList().get(0);
    }

    @Override
    public void update(Integer id, Role role2) {
        Session session = sessionFactory.getCurrentSession();
        Role role1 = session.byId(Role.class).load(id);
        role1.setName(role2.getName());
        role1.setExt_id(role2.getExt_id());
        session.flush();
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Role role = session.byId(Role.class).load(id);
        session.delete(role);
    }

    @Override
    public List<Role> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);
        Root<Role> root = cq.from(Role.class);
        cq.select(root);
        Query<Role> query = session.createQuery(cq);
        return query.getResultList();
    }
}
