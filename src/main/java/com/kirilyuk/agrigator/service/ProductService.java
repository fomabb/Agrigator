package com.kirilyuk.agrigator.service;

import com.kirilyuk.agrigator.dto.FindAllDTO;
import com.kirilyuk.agrigator.entities.Product;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts(PageRequest of);

    public Product getProductById(Long id);

    public List<Product> getTitleProduct(String title);

    public List<Product> findByCategory(String category);

    /**
     * Methods for parsing
     */
    public boolean isExist(String obj);

    public List<FindAllDTO> testFindAllDTO();

}
