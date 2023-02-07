package com.kirilyuk.agrigator.service;

import com.kirilyuk.agrigator.dao.ReviewsDAO;
import com.kirilyuk.agrigator.dao.UserDAO;
import com.kirilyuk.agrigator.dto.UserReviewDTO;
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
    public void saveReviews(UserReviewDTO reviews) {

        UserReview userReview = new UserReview();

        userReview.setLogin(reviews.getLogin());
        userReview.setEmail(reviews.getEmail());
        userReview.setStatusReview(StatusReview.valueOf(StatusReview.PROCESSED.toString()
                .toUpperCase(Locale.ROOT)));
        userReview.setStatusReviewId(reviews.getStatusReviewId());

        switch (userReview.getStatusReviewId()) {
            case 1 -> userReview.setStatusReview(StatusReview.valueOf(StatusReview.PASSED.toString()
                    .toUpperCase(Locale.ROOT)));
            case 2 -> userReview.setStatusReview(StatusReview.valueOf(StatusReview.FAILED.toString()
                    .toUpperCase(Locale.ROOT)));
        }

        reviewsDAO.save(userReview);
    }
}
