package com.kirilyuk.agrigator.dao;

import com.kirilyuk.agrigator.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {


    @Query("select obj from Product obj where obj.parent_category=:parent_category")
    List<Product> findByCategoryParent(@Param("parent_category") String category);

    @Query("select obj from Product obj where obj.child_category=:child_category")
    List<Product> findByCategoryChild(@Param("child_category") String category);

    @Query("select obj from Product obj where obj.title ilike %:text% or obj.info ilike %:text%")
    List<Product> findAllProductByDescription(String text);
}
