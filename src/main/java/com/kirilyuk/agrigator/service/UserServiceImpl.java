package com.kirilyuk.agrigator.service;

import com.kirilyuk.agrigator.dao.ReviewsDAO;
import com.kirilyuk.agrigator.dao.UserDAO;
import com.kirilyuk.agrigator.dto.ReviewUpdate;
import com.kirilyuk.agrigator.dto.UserReviewDTO;
import com.kirilyuk.agrigator.dto.UserReviewDataDTO;
import com.kirilyuk.agrigator.entities.UserReview;
import com.kirilyuk.agrigator.entities.Users;
import com.kirilyuk.agrigator.enumerated.StatusReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO dao;
    private final ReviewsDAO reviewsDAO;

    @Autowired
    public UserServiceImpl(UserDAO dao, ReviewsDAO reviewsDAO) {
        this.dao = dao;
        this.reviewsDAO = reviewsDAO;
    }

    @Override
    public List<Users> getAllUsers() {

        return dao.findAll();
    }

    @Override
    public void deleteProduct(Long id) {

        dao.deleteById(id);
    }

    @Override
    public void deleteAllProducts() {

        dao.deleteAll();
    }

    @Override
    public void saveReviews(UserReviewDTO reviews) {

        UserReview userReview = new UserReview();

        userReview.setLogin(reviews.getLogin());
        userReview.setEmail(reviews.getEmail());
        userReview.setReviews(reviews.getReviews());
        userReview.setStatus(StatusReview.PROCESSED);
        userReview.setStatus_review_id(reviews.getStatus_review_id());

//        switch (userReview.getStatus_review_id()) {
//            case 1 -> userReview.setStatus(StatusReview.valueOf(
//                    StatusReview.PASSED.toString().toUpperCase(Locale.ROOT)));
//
//            case 2 -> userReview.setStatus(StatusReview.valueOf(
//                    StatusReview.FAILED.toString().toUpperCase(Locale.ROOT)));
//        }
        reviewsDAO.save(userReview);
    }

    @Override
    public List<UserReviewDataDTO> getAllReview() {

        return reviewsDAO.findAll().stream().map(userReview -> new UserReviewDataDTO(userReview.getReviews(),
                        userReview.getStatus(), userReview.getStatus_review_id()))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserReviewDataDTO> getAllStatusProcessed(Integer status) {

        return reviewsDAO.getAllStatusProcessed(status).stream().map(userReview -> new UserReviewDataDTO(userReview.getReviews(),
                        userReview.getStatus(), userReview.getStatus_review_id()))
                .collect(Collectors.toList());
    }


    @Override
    @Transactional
    public void updateReview(Long id, ReviewUpdate review) {
        getById(id);

        switch (review.getStatus_review_id()) {
            case 1 -> review.setStatusReview(StatusReview.valueOf(
                    StatusReview.PASSED.toString().toUpperCase(Locale.ROOT)));

            case 2 -> review.setStatusReview(StatusReview.valueOf(
                    StatusReview.FAILED.toString().toUpperCase(Locale.ROOT)));
        }
        reviewsDAO.updateReview(id, review);
    }

    @Override
    public UserReview getById(Long id) {

        return reviewsDAO.findById(id).orElseThrow();
    }
}
