package com.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "dictionary")
@DiscriminatorValue("role")
public class Role extends Dictionary {

    public Role() {
    }
}
