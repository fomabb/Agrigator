package com.kirilyuk.agrigator.service;

import com.kirilyuk.agrigator.entities.UserReview;
import com.kirilyuk.agrigator.entities.Users;

import java.util.List;

public interface UserService {
    List<Users> getAllUsers();

    void deleteProduct(Long id);

    void deleteAllProducts();

    void saveReviews(UserReview reviews);

    List<UserReview> getAllStatusProcessed();

//    void updateReview(ReviewUpdateDTO review);

    UserReview getById(Long id);

    List<UserReview> allReview();
}