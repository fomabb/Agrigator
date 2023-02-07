package com.kirilyuk.agrigator.service;

import com.kirilyuk.agrigator.dao.ProductDAO;
import com.kirilyuk.agrigator.dto.FindAllDTO;
import com.kirilyuk.agrigator.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO dao;

    @Autowired
    public ProductServiceImpl(ProductDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Product> getAllProducts(PageRequest of) {

        return dao.findAll();
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
    public List<Product> getCategoryDriveTechnology(String category) {

        return dao.getCategoryDriveTechnology(category);
    }

    @Override
    public List<Product> getCategoryAutomationTechnology(String category) {

        return dao.getCategoryAutomationTechnology(category);
    }

    @Override
    public List<Product> getCategoryEverythingElse(String category) {

        return dao.getCategoryEverythingElse(category);
    }

    @Override
    public List<Product> findByCategory(String category) {

        return dao.findByCategory(category);
    }

    @Override
    public void productSave(Product product) {

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

    @Override
    public List<FindAllDTO> testFindAllDTO() {

        return dao.findAll().stream().map(product -> new FindAllDTO(product.getTitle(), product.getInfo(),
                        product.getCategory(), product.getImage()))
                .collect(Collectors.toList());
    }
}
