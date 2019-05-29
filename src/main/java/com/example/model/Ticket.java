package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_user", nullable = false)
    private Integer id_user;

    @Column(name = "id_session", nullable = false)
    private Integer id_show;

    @Column(name = "id_seat", nullable = false)
    private Integer id_seat;

    public Ticket() {
    }

    public Ticket(Integer id_user, Integer id_show, Integer id_seat) {
        this.id_user = id_user;
        this.id_show = id_show;
        this.id_seat = id_seat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_show() {
        return id_show;
    }

    public void setId_show(Integer id_show) {
        this.id_show = id_show;
    }

    public Integer getId_seat() {
        return id_seat;
    }

    public void setId_seat(Integer id_seat) {
        this.id_seat = id_seat;
    }
}
