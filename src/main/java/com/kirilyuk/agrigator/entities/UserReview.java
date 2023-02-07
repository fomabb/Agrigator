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

    @Column(name = "login")
    private String login;

    @Column(name = "email")
    private String email;

    @Column(name = "reviews", columnDefinition = "text")
    private String reviews;

    private StatusReview statusReview;

    private int statusReviewId;
}
