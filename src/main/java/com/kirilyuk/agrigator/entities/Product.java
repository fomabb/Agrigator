package com.kirilyuk.agrigator.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", columnDefinition = "text")
    private String title;

    @Column(name = "info", columnDefinition = "text")
    private String info;

    @Column(name = "image", columnDefinition = "text")
    private String image;

    @Column(name = "link_production", columnDefinition = "text")
    private String link_production;

    @Column(name = "category", columnDefinition = "text")
    private String category;

    @Column(name = "unique_number", columnDefinition = "text")
    private String unique_number;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "price_id")
//    private List<Price> prices;

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink_production() {
        return link_production;
    }

    public void setLink_production(String link_production) {
        this.link_production = link_production;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnique_number() {
        return unique_number;
    }

    public void setUnique_number(String unique_number) {
        this.unique_number = unique_number;
    }

//    public List<Price> getList() {
//        return prices;
//    }
//
//    public void setList(List<Price> list) {
//        this.prices = list;
//    }
}
