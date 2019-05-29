package com.example.service;

import com.example.dao.SeatDao;
import com.example.model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatDao seatDao;

    @Override
    @Transactional
    public Integer save(Seat seat) {
        return seatDao.save(seat);
    }

    @Override
    public Seat get(Integer id) {
        return seatDao.get(id);
    }

    @Override
    @Transactional
    public void update(Integer id, Seat seat) {
        seatDao.update(id, seat);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        seatDao.delete(id);
    }

    @Override
    public List<Seat> list() {
        return seatDao.list();
    }
}
