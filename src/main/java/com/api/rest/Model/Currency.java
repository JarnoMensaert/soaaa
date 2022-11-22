package com.api.rest.Model;

import javax.persistence.*;

@Entity
public class Currency {

    @Id
    private String name;

    @Column
    private double value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
