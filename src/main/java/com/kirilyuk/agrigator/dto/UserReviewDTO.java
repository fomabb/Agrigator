package com.kirilyuk.agrigator.dto;


import com.kirilyuk.agrigator.enumerated.StatusReview;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReviewDTO {

    private String login;

    private String email;

    private String reviews;

    @Enumerated(value = EnumType.STRING)
    private StatusReview status;

    private int status_review_id;
}
