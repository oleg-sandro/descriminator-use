package com.example.service;

import com.example.dao.FilmDao;
import com.example.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmDao filmDao;

    @Override
    @Transactional
    public Integer save(Film film) {
        return filmDao.save(film);
    }

    @Override
    public Film get(Integer id) {
        return filmDao.get(id);
    }

    @Override
    @Transactional
    public void update(Integer id, Film film) {
        filmDao.update(id, film);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        filmDao.delete(id);
    }

    @Override
    public List<Film> list() {
        return filmDao.list();
    }
}
