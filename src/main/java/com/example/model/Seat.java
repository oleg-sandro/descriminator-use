package com.example.model;

import javax.persistence.*;

public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_hall", nullable = false)
    private Integer id_hall;

    @Column(name = "row", nullable = false)
    private Integer row;

    @Column(name = "number", nullable = false)
    private Integer number;

    public Seat() {
    }

    public Seat(Integer id_hall, Integer row, Integer number) {
        this.id_hall = id_hall;
        this.row = row;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_hall() {
        return id_hall;
    }

    public void setId_hall(Integer id_hall) {
        this.id_hall = id_hall;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
