package com.kirilyuk.agrigator.dto;


import com.kirilyuk.agrigator.enumerated.StatusReview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReviewDTO {

    private String login;

    private String email;

    private String review;

    private StatusReview statusReview;

    private int statusReviewId = 1;
}
