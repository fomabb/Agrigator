package com.kirilyuk.agrigator.service.impl;

import com.kirilyuk.agrigator.dao.ProductDAO;
import com.kirilyuk.agrigator.entities.Product;
import com.kirilyuk.agrigator.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO dao;

    @Autowired
    public ProductServiceImpl(ProductDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {

        return dao.findAll();
    }

    @Override
    @Transactional
    public Product getProductById(Long id) {

        return dao.findById(id).orElseThrow();
    }


    @Override
    @Transactional
    public List<Product> findByCategoryParent(String category) {

        return dao.findByCategoryParent(category);
    }

    @Override
    @Transactional
    public List<Product> findByCategoryChild(String category) {

        return dao.findByCategoryChild(category);
    }

    @Override
    @Transactional
    public List<Product> findAllProductByDescription(String text) {

        return dao.findAllProductByDescription(text);
    }

//    @Override
//    public boolean isExist(String obj) {
//        List<Product> allProduct = dao.findAll();
//        for (Product p : allProduct) {
//            if (p.getTitle().equals(obj) || p.getInfo().equals(obj) || p.getImage().equals(obj)
//                    || p.getLink_production().equals(obj) || p.getUnique_number().equals(obj)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
