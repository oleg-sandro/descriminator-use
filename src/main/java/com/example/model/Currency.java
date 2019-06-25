package com.example.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dictionary")
@DiscriminatorValue("currency")
public class Currency extends Dictionary {

    public Currency() {
    }

    public Currency(String name) {
        this.name = name;
    }
}
