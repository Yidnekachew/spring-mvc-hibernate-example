package com.spring.dynamic.web.model;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Table(appliesTo = "hotel")
public class Hotel implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty
    private String name;

    public Hotel() {
    }

    public Hotel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
