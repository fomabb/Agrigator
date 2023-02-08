package com.kirilyuk.agrigator.service;

import com.kirilyuk.agrigator.dao.ReviewsDAO;
import com.kirilyuk.agrigator.dao.UserDAO;
import com.kirilyuk.agrigator.entities.UserReview;
import com.kirilyuk.agrigator.entities.Users;
import com.kirilyuk.agrigator.enumerated.StatusReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

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
    public void saveReviews(UserReview reviews) {

        reviews.setStatus(StatusReview.PROCESSED);

        switch (reviews.getStatus_review_id()) {
            case 1 -> reviews.setStatus(StatusReview.valueOf(
                    StatusReview.PASSED.toString().toUpperCase(Locale.ROOT)));

            case 2 -> reviews.setStatus(StatusReview.valueOf(
                    StatusReview.FAILED.toString().toUpperCase(Locale.ROOT)));
        }
        reviewsDAO.saveAndFlush(reviews);
    }

    @Override
    public List<UserReview> getAllStatusProcessed() {

        return reviewsDAO.getAllStatusProcessed();
    }

    @Override
    public UserReview getById(Long id) {

        return reviewsDAO.findById(id).orElseThrow();
    }

    @Override
    public List<UserReview> allReview() {

        return reviewsDAO.findAll();
    }

    @Override
    public List<UserReview> deleteReviewFailed() {

        return reviewsDAO.deleteReviewFailed();
    }
}
