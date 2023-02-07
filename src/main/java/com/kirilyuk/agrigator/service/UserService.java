package com.kirilyuk.agrigator.service;

import com.kirilyuk.agrigator.dto.ReviewUpdate;
import com.kirilyuk.agrigator.dto.UserReviewDTO;
import com.kirilyuk.agrigator.dto.UserReviewDataDTO;
import com.kirilyuk.agrigator.entities.UserReview;
import com.kirilyuk.agrigator.entities.Users;

import java.util.List;

public interface UserService {
    List<Users> getAllUsers();

    void deleteProduct(Long id);

    void deleteAllProducts();

    void saveReviews(UserReviewDTO reviews);

    List<UserReviewDataDTO> getAllReview();

    List<UserReviewDataDTO> getAllStatusProcessed(Integer status);

    void updateReview(Long id, ReviewUpdate review);

    UserReview getById(Long id);
}