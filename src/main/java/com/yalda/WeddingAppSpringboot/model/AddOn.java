package com.yalda.WeddingAppSpringboot.model;

import javax.persistence.*;

@Entity
@Table(name = "add_Ons")
public class AddOn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    double price;
    String name;
    String detail;


    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return detail;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.detail = details;
    }
}
