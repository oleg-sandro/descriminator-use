package com.example.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "session")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_film", nullable = false)
    private Integer id_film;

    @Column(name = "when_start", nullable = false)
    private Timestamp when_start;

    @Column(name = "id_hall", nullable = false)
    private Integer id_hall;

    public Show() {
    }

    public Show(Integer id_film, Timestamp when_start, Integer id_hall) {
        this.id_film = id_film;
        this.when_start = when_start;
        this.id_hall = id_hall;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_film() {
        return id_film;
    }

    public void setId_film(Integer id_film) {
        this.id_film = id_film;
    }

    public Timestamp getWhen_start() {
        return when_start;
    }

    public void setWhen_start(Timestamp when_start) {
        this.when_start = when_start;
    }

    public Integer getId_hall() {
        return id_hall;
    }

    public void setId_hall(Integer id_hall) {
        this.id_hall = id_hall;
    }
}
