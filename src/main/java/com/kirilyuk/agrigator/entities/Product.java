package com.kirilyuk.agrigator.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
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

    @Column(name = "parent_category", columnDefinition = "text")
    private String parent_category;

    @Column(name = "child_category", columnDefinition = "text")
    private String child_category;

    @Column(name = "unique_number", columnDefinition = "text")
    private String unique_number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ebay_id")
    private EbayPrice prices;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "google_id")
    private GoogleShop googleShop;
}
