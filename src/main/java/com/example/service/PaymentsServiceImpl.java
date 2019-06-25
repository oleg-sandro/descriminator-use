package com.example.service;

import com.example.dao.PaymentsDao;
import com.example.model.Payments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PaymentsServiceImpl implements PaymentsService {

    @Autowired
    private PaymentsDao paymentsDao;


    @Override
    @Transactional
    public Integer save(Payments payments) {
        return paymentsDao.save(payments);
    }

    @Override
    public List<Payments> get(Integer id_user) {
        return paymentsDao.get(id_user);
    }

    @Override
    @Transactional
    public void update(Integer id, Payments payments) {
        paymentsDao.update(id, payments);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        paymentsDao.delete(id);
    }

    @Override
    public List<Payments> list() {
        return paymentsDao.list();
    }
}
