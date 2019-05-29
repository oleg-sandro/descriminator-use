package com.example.service;

import com.example.dao.HallDao;
import com.example.model.Hall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class HallServiceImpl implements HallService {

    @Autowired
    private HallDao hallDao;

    @Override
    @Transactional
    public Integer save(Hall hall) {
        return hallDao.save(hall);
    }

    @Override
    public Hall get(Integer id) {
        return hallDao.get(id);
    }

    @Override
    public Hall get(String number) {
        return hallDao.get(number);
    }

    @Override
    @Transactional
    public void update(Integer id, Hall hall) {
        hallDao.update(id, hall);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        hallDao.delete(id);
    }

    @Override
    public List<Hall> list() {
        return hallDao.list();
    }
}
