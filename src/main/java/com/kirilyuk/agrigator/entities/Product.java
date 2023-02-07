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

    @Column(name = "category", columnDefinition = "text")
    private String category;

    @Column(name = "unique_number", columnDefinition = "text")
    private String unique_number;
}
