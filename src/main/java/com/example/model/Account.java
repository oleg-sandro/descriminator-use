package com.example.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_user", nullable = true)
    private Integer id_user;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "id_currency", nullable = false)
    private Integer id_currency;

    public Account() {
    }

    public Account(Integer id_user, BigDecimal amount, Integer id_currency) {
        this.id_user = id_user;
        this.amount = amount;
        this.id_currency = id_currency;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getId_currency() {
        return id_currency;
    }

    public void setId_currency(Integer id_currency) {
        this.id_currency = id_currency;
    }
}
