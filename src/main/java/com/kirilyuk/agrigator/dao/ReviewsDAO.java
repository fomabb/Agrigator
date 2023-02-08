package com.kirilyuk.agrigator.dao;

import com.kirilyuk.agrigator.entities.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewsDAO extends JpaRepository<UserReview, Long> {

    @Query(value = "select * from reviews r where r.status_review_id=0", nativeQuery = true)
    List<UserReview> getAllStatusProcessed();

    @Query(value = "delete from reviews r where r.status_review_id=2", nativeQuery = true)
    List<UserReview> deleteReviewFailed();
}