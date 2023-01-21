package com.kirilyuk.agrigator.service;

import com.kirilyuk.agrigator.entities.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();

    public void saveProduct(List<Product> product);

    public Product getProductById(Long id);

    public List<Product> getTitleProduct(String title);

    public void deleteProduct(Long id);

    public void deleteAllProducts();

    /**
     * Methods for parsing
     */
    public void save(Product product);

    public boolean isExist(String obj);

    public List<Product> getCategoryMoto(String category);

    public List<Product> getCategoryMobile(String category);

    public List<Product> findByCategory(String category);
}
