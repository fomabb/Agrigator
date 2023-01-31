package com.kirilyuk.agrigator.controller;

import com.kirilyuk.agrigator.entities.Product;
import com.kirilyuk.agrigator.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/find/all")
    public List<Product> getAllProducts() {

        return service.getAllProducts();
    }

    @GetMapping("/find/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return service.getProductById(id);
    }

    @GetMapping("/find/category/parent") // вывод категории тест db
    public List<Product> findByCategoryParent(@RequestParam("parent_category") String category) {

        return service.findByCategoryParent(category);
    }

    @GetMapping("/find/category/child")
    public List<Product> findByCategoryChild(@RequestParam("child_category") String category) {

        return service.findByCategoryChild(category);
    }

    @GetMapping("find/description")
    public List<Product> findAllProductByDescription(@RequestParam(required = false) String text) {

        return service.findAllProductByDescription(text);
    }
}