package com.example.dao;

import com.example.entities.Role;
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
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    public int save(Role role) {
        sessionFactory.getCurrentSession().save(role);
        return role.getId();
    }

    public Role get(int id) {
        return sessionFactory.getCurrentSession().get(Role.class, id);
    }

    public void update(int id, Role role2) {
        Session session = sessionFactory.getCurrentSession();
        Role role1 = session.byId(Role.class).load(id);
        role1.setName(role2.getName());
        role1.setExt_id(role2.getExt_id());
        session.flush();
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Role role = session.byId(Role.class).load(id);
        session.delete(role);
    }

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
