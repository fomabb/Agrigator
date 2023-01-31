package com.kirilyuk.agrigator.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "google_shope")
@Data
@NoArgsConstructor
public class GoogleShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String price;

    private String price_order;

    private String delivery_speed;

    @Column(columnDefinition = "text")
    private String link_product;

    @Column(columnDefinition = "text")
    private String link_image;

    private String name_seller;
}