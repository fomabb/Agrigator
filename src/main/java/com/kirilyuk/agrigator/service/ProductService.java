package com.kirilyuk.agrigator.service;

import com.kirilyuk.agrigator.entities.Product;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts(int page, int pageSize);

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
