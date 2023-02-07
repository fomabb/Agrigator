package com.kirilyuk.agrigator.dao;

import com.kirilyuk.agrigator.entities.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsDAO extends JpaRepository<UserReview, Long> {

}
