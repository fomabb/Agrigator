package com.kirilyuk.agrigator.controller;

import com.kirilyuk.agrigator.dto.FindAllDTO;
import com.kirilyuk.agrigator.dto.UserReviewDTO;
import com.kirilyuk.agrigator.entities.Product;
import com.kirilyuk.agrigator.service.ProductService;
import com.kirilyuk.agrigator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

    private final ProductService service;
    private final UserService userService;

    @Autowired
    public ProductController(ProductService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping("/test")
    public List<FindAllDTO> testFindAllDTO() {

        return service.testFindAllDTO();
    }

    @GetMapping("/find/all")
    public List<Product> getAllProducts(@RequestParam("offset") Integer offset,
                                        @RequestParam("limit") Integer limit) {

        return service.getAllProducts(PageRequest.of(offset, limit));
    }

    @GetMapping("/find/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return service.getProductById(id);
    }

    @GetMapping("/find/title")
    public List<Product> getTitleProduct(@RequestParam("title") String title) {

        return service.getTitleProduct(title);
    }

    @GetMapping("/category/drive_technology") // вывод по определенной категории тест db
    public List<Product> getCategoryDriveTechnology(String category) {

        return service.getCategoryDriveTechnology(category);
    }

    @GetMapping("/category/automation_technology") // вывод по определенной категории тест db
    public List<Product> getCategoryAutomationTechnology(String category) {

        return service.getCategoryAutomationTechnology(category);
    }

    @GetMapping("/category/everything") //... and everything else you need
    public List<Product> getCategoryEverythingElse(String category) {

        return service.getCategoryEverythingElse(category);
    }

    @GetMapping("/find/category") // вывод категории тест db
    public List<Product> findByCategory(@RequestParam("category") String category) {

        return service.findByCategory(category);
    }

    @PostMapping("/save/reviews")
    public void saveReviews(@RequestBody UserReviewDTO reviews) {

        userService.saveReviews(reviews);
    }
}