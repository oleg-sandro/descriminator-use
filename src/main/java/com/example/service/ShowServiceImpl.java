package com.example.service;

import com.example.dao.ShowDao;
import com.example.model.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowDao showDao;

    @Override
    @Transactional
    public Integer save(Show show) {
        return showDao.save(show);
    }

    @Override
    public Show get(Integer id) {
        return showDao.get(id);
    }

    @Override
    @Transactional
    public void update(Integer id, Show show) {
        showDao.update(id, show);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        showDao.delete(id);
    }

    @Override
    public List<Show> list() {
        return showDao.list();
    }
}
