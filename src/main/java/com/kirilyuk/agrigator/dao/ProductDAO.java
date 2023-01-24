package com.kirilyuk.agrigator.dao;

import com.kirilyuk.agrigator.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {

    @Query("select obj from Product obj where obj.title ilike %:title%")
    public List<Product> getTitleProduct(@Param("title") String title);

    @Query("select  obj from Product obj where obj.category='Drive technology'")
    public List<Product> getCategoryDriveTechnology(String category);

    @Query("select obj from Product obj where obj.category='Automation technology'")
    public List<Product> getCategoryAutomationTechnology(String category);

    @Query("select obj from Product obj where obj.category like '... and everything else you need'")
    public List<Product> getCategoryEverythingElse(String category);  // ... and everything else you need

    @Query("select obj from Product obj where obj.category=:category")
    public List<Product> findByCategory(@Param("category") String category);
}
