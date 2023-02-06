package com.kirilyuk.agrigator.dao;

import com.kirilyuk.agrigator.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {

//    make_tsvector_idx(title, info)

    @Query("select obj from Product obj where obj.parent_category=:parent_category")
    List<Product> findByCategoryParent(@Param("parent_category") String category);

    @Query("select obj from Product obj where obj.child_category=:child_category")
    List<Product> findByCategoryChild(@Param("child_category") String category);

    @Query(value = "select * from product p where make_tsvector_idx(p.title, p.info) @@ to_tsquery(:text)",
            nativeQuery = true)
    List<Product> findAllProductByDescription(@Param("text") String text);

//    @Query(value = "select * from product p where make_tsvector_idx(p.title, p.info) @@ to_tsquery('samsung')",
//            nativeQuery = true)
    @Query(value = "select * from product p where make_tsvector_idx(p.title, p.info) @@ to_tsquery('samsung')", nativeQuery = true)
    List<Product> searchTest();
}
