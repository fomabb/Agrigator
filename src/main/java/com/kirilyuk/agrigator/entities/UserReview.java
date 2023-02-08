package com.kirilyuk.agrigator.entities;

import com.kirilyuk.agrigator.enumerated.StatusReview;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
public class UserReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "reviews")
    private String reviews;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private StatusReview status;

    @Column(name = "status_review_id")
    private int status_review_id;
}
