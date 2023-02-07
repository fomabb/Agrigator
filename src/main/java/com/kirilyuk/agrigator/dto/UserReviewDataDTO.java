package com.kirilyuk.agrigator.dto;

import com.kirilyuk.agrigator.enumerated.StatusReview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReviewDataDTO {

    private String reviews;

    private StatusReview status;
    private int status_review_id;
}
