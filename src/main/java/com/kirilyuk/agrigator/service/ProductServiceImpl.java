package com.kirilyuk.agrigator.service;

import com.kirilyuk.agrigator.dao.ProductDAO;
import com.kirilyuk.agrigator.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO dao;

    @Autowired
    public ProductServiceImpl(ProductDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Product> getAllProducts() {

        return dao.findAll();
    }

    @Override
    public void saveProduct(List<Product> product) {

        dao.saveAll(product);
    }

    @Override
    public Product getProductById(Long id) {

        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<Product> getTitleProduct(String title) {

        return dao.getTitleProduct(title);
    }

    @Override
    public void deleteProduct(Long id) {

        dao.deleteById(id);
    }

    @Override
    public void deleteAllProducts() {

        dao.deleteAll();
    }

    @Override
    public List<Product> getCategoryMoto(String category) {

        return dao.getCategoryMoto(category);
    }

    @Override
    public List<Product> getCategoryMobile(String category) {

        return dao.getCategoryMobile(category);
    }

    @Override
    public List<Product> findByCategory(String category) {

        return dao.findByCategory(category);
    }

    @Override
    public void save(Product product) {

        dao.save(product);
    }

    @Override
    public boolean isExist(String obj) {
        List<Product> allProduct = dao.findAll();
        for (Product p : allProduct) {
            if (p.getTitle().equals(obj) || p.getInfo().equals(obj) || p.getImage().equals(obj)
                    || p.getLink_production().equals(obj) || p.getUnique_number().equals(obj)) {
                return true;
            }
        }
        return false;
    }
}
