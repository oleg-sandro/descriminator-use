package com.example.dao;

import com.example.model.Show;

import java.util.List;

public interface ShowDao {

    Integer save(Show show);
    Show get(Integer id);
    void update(Integer id, Show show);
    void delete(Integer id);
    List<Show> list();
}
