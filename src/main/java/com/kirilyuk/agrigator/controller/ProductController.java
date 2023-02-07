package com.kirilyuk.agrigator.controller;

import com.kirilyuk.agrigator.dto.FindAllDTO;
import com.kirilyuk.agrigator.dto.ReviewUpdate;
import com.kirilyuk.agrigator.dto.UserReviewDTO;
import com.kirilyuk.agrigator.dto.UserReviewDataDTO;
import com.kirilyuk.agrigator.entities.Product;
import com.kirilyuk.agrigator.entities.UserReview;
import com.kirilyuk.agrigator.service.ProductService;
import com.kirilyuk.agrigator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
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

    @GetMapping("/find/category") // вывод категории тест db
    public List<Product> findByCategory(@RequestParam("category") String category) {

        return service.findByCategory(category);
    }

//    ==================================================================================================================

    @PostMapping("/save/reviews")
    public UserReviewDTO saveReviews(@RequestBody UserReviewDTO reviews) {

        userService.saveReviews(reviews);

        return reviews;
    }

    @GetMapping("/review/{id}")
    public UserReview getById(@PathVariable("id") Long id) {

        return userService.getById(id);
    }

    @PutMapping("/update/{id}")
    public ReviewUpdate updateReviews(@PathVariable("id") Long id,
                                      @RequestBody ReviewUpdate review) {

        userService.updateReview(id, review);

        return review;
    }

    @GetMapping
    public List<UserReviewDataDTO> getAllReview() {

        return userService.getAllReview();
    }

    @GetMapping("/reviews")
    public List<UserReviewDataDTO> getAllStatusProcessed(@RequestParam("status") Integer status) {

        return userService.getAllStatusProcessed(status);
    }
}