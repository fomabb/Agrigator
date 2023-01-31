package com.kirilyuk.agrigator.controller;


import com.kirilyuk.agrigator.entities.Product;
import com.kirilyuk.agrigator.entities.Users;
import com.kirilyuk.agrigator.service.ProductService;
import com.kirilyuk.agrigator.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final ProductService productService;

    private final UserService usersService;

    public AdminController(ProductService service, UserService usersService) {
        this.productService = service;
        this.usersService = usersService;
    }

    @GetMapping("/find/all")
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/find/{id}")
    public Product findProductById(@PathVariable("id") Long id) {

        return productService.getProductById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {

        usersService.deleteProduct(id);

        return "Product with ID=" + id + " was deleted";
    }

    @DeleteMapping("/clean")
    public void deleteAllProducts() {

        usersService.deleteAllProducts();
    }

    @GetMapping("/user/all")
    public List<Users> getAllUsers() {

        return usersService.getAllUsers();
    }
}