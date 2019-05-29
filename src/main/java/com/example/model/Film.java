package com.example.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "year")
    private Integer year;

    @Column(name = "country")
    private String country;

    @Column(name = "producer")
    private String producer;

    @Column(name = "genre")
    private String genre;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "description")
    private String description;

    @Column(name = "when_start", nullable = false)
    private Timestamp when_start;

    @Column(name = "when_finish", nullable = false)
    private Timestamp when_finish;

    public Film() {
    }

    public Film(String title, Timestamp when_start, Timestamp when_finish) {
        this.title = title;
        this.when_start = when_start;
        this.when_finish = when_finish;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getWhen_start() {
        return when_start;
    }

    public void setWhen_start(Timestamp when_start) {
        this.when_start = when_start;
    }

    public Timestamp getWhen_finish() {
        return when_finish;
    }

    public void setWhen_finish(Timestamp when_finish) {
        this.when_finish = when_finish;
    }
}
