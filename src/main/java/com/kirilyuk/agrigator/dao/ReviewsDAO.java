package com.kirilyuk.agrigator.dao;

import com.kirilyuk.agrigator.dto.ReviewUpdate;
import com.kirilyuk.agrigator.dto.UserReviewDataDTO;
import com.kirilyuk.agrigator.entities.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ReviewsDAO extends JpaRepository<UserReview, Long> {

//    @Query(value = "select u from UserReview u where u.statusReview='PROCESSED'", nativeQuery = true)
    @Query(value = "select r from UserReview r where r.status_review_id=:status")
    List<UserReviewDataDTO> getAllStatusProcessed(@Param("status") Integer status);

    @Query(value = "UPDATE reviews SET status_review_id=? WHERE id=?", nativeQuery = true)
    void updateReview(Long id, ReviewUpdate review);


}
//'PROCESSED'

//UPDATE employee SET department_id=?, job_title=? WHERE employee_id=?