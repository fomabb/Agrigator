package com.kirilyuk.agrigator.entities;

import jakarta.persistence.*;

//@Entity
//@Table(name = "price")
public class Price {
    @Id
    private Long id;

    private int price_first;

    private int price_second;

    private int price_third;

//    @ManyToOne(fetch = FetchType.EAGER)
//    private Product product;

    public Long getId() {
        return id;
    }

    public Price() {
    }

    public Price(int price_first, int price_second, int price_third, Product product) {
        this.price_first = price_first;
        this.price_second = price_second;
        this.price_third = price_third;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice_first() {
        return price_first;
    }

    public void setPrice_first(int price_first) {
        this.price_first = price_first;
    }

    public int getPrice_second() {
        return price_second;
    }

    public void setPrice_second(int price_second) {
        this.price_second = price_second;
    }

    public int getPrice_third() {
        return price_third;
    }

    public void setPrice_third(int price_third) {
        this.price_third = price_third;
    }

//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
}
