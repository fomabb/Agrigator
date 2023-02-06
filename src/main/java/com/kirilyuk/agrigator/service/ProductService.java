package com.kirilyuk.agrigator.service;

import com.kirilyuk.agrigator.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    List<Product> findByCategoryParent(String category);

    List<Product> findByCategoryChild(String category);

    List<Product> findAllProductByDescription(String text);

    List<Product> searchTest();

    /**
     * Methods for parsing
     */
//    boolean isExist(String obj);
}
