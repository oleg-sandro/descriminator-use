package com.example.dao;

import com.example.model.Account;
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
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Integer save(Account account) {
        sessionFactory.getCurrentSession().save(account);
        return account.getId();
    }

    @Override
    public List<Account> get(Integer id_user) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Account> cq = cb.createQuery(Account.class);
        Root<Account> root = cq.from(Account.class);
        cq.select(root).where(cb.equal(root.get("id_user"), id_user));
        Query<Account> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void update(Integer id, Account account2) {
        Session session = sessionFactory.getCurrentSession();
        Account account1 = session.byId(Account.class).load(id);
        account1.setId_user(account2.getId_user());
        account1.setAmount(account2.getAmount());
        account1.setId_currency(account2.getId_currency());
        session.flush();
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Account account = session.byId(Account.class).load(id);
        session.delete(account);
    }

    @Override
    public List<Account> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Account> cq = cb.createQuery(Account.class);
        Root<Account> root = cq.from(Account.class);
        cq.select(root);
        Query<Account> query = session.createQuery(cq);
        return query.getResultList();
    }
}
