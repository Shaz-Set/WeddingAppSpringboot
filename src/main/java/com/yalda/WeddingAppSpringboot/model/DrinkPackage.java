package com.yalda.WeddingAppSpringboot.model;

import javax.persistence.*;

@Entity
@Table(name = "drink_Packages")
public class DrinkPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    double price;
    String name;
    String details;


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
        return details;
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
        this.details = details;
    }

    @Override
    public String toString() {
        return "Drink package number " + this.id + "\n" +
                "Name: " + this.name + "\n" +
                "Details: " + this.details + "\n" +
                "Price: $" + this.price + "\n";
    }
}
