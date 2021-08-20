package com.yalda.WeddingAppSpringboot.model;

import net.bytebuddy.implementation.bytecode.assign.TypeCasting;

import javax.persistence.*;


@Entity
@Table(name = "wedding_Packages")
public class WeddingPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int hours;
    String name;
    String styles; //sited down or roving
    double price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getStyles() {
        return styles;
    }

    public void setStyles(String styles) {
        this.styles = styles;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
