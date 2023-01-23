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

    @PostMapping("/save")
    public void saveProduct(@RequestBody List<Product> product) {
        service.saveProduct(product);
    }

    @GetMapping("/find/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return service.getProductById(id);
    }

    @GetMapping("/find/title")
    public List<Product> getTitleProduct(@RequestParam("title") String title) {

        return service.getTitleProduct(title);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {

        service.deleteProduct(id);

        return "Product with ID=" + id + " was deleted";
    }

    @DeleteMapping("/clean")
    public void deleteAllProducts() {

        service.deleteAllProducts();
    }

    @GetMapping("/category/drive_technology") // вывод по определенной категории тест db
    public List<Product> getCategoryMoto(String category) {

        return service.getCategoryMoto(category);
    }

    @GetMapping("/category/automation_technology") // вывод по определенной категории тест db
    public List<Product> getCategoryMobile(String category) {

        return service.getCategoryMobile(category);
    }

    @GetMapping("/find/category") // вывод категории тест db
    public List<Product> findByCategory(@RequestParam("category") String category) {

        return service.findByCategory(category);
    }
}

/**
 * INPOINTs
 * /api/product/find/all            - вывод всех продуктов
 * /api/product/find/{id}           - вывод по ID продукта
 * /api/product/find/title          - поиск по названию товара
 * /api/product/category/moto       - вывод по категории (test_db)
 * /api/product/category/mobile     - вывод по категории (test_db)
 * /api/product/find/category       - поиск по категории
 * for Admin
 * /api/product/save                - добавить продукт
 * /api/product/delete/{id}         - удалить продукт
 * /api/product/clean               - отчистить базу данных
 */
