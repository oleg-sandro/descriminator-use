package com.example.service;

import com.example.model.Show;

import java.util.List;

public interface ShowService {

    Integer save(Show show);
    Show get(Integer id);
    void update(Integer id, Show show);
    void delete(Integer id);
    List<Show> list();
}
