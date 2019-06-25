package com.example.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "payments")
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_ticket", nullable = true)
    private Integer id_ticket;

    @Column(name = "id_account", nullable = false)
    private Integer id_account;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "id_currency", nullable = false)
    private Integer id_currency;

    @Column(name = "operation_date", nullable = false)
    private Timestamp operation_date;

    public Payments() {
    }

    public Payments(Integer id_ticket, Integer id_account, BigDecimal amount, Integer id_currency, Timestamp operation_date) {
        this.id_ticket = id_ticket;
        this.id_account = id_account;
        this.amount = amount;
        this.id_currency = id_currency;
        this.operation_date = operation_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(Integer id_ticket) {
        this.id_ticket = id_ticket;
    }

    public Integer getId_account() {
        return id_account;
    }

    public void setId_account(Integer id_account) {
        this.id_account = id_account;
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

    public Timestamp getOperation_date() {
        return operation_date;
    }

    public void setOperation_date(Timestamp operation_date) {
        this.operation_date = operation_date;
    }
}
