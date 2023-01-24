package com.kirilyuk.agrigator.service;

import com.kirilyuk.agrigator.dto.FindAllDTO;
import com.kirilyuk.agrigator.entities.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();

    public Product getProductById(Long id);

    public List<Product> getTitleProduct(String title);


    public List<Product> getCategoryDriveTechnology(String category);

    public List<Product> getCategoryAutomationTechnology(String category);

    public List<Product> getCategoryEverythingElse(String category);

    public List<Product> findByCategory(String category);

    /**
     * Methods for parsing
     */
    public boolean isExist(String obj);

    public List<FindAllDTO> testFindAllDTO();

}
