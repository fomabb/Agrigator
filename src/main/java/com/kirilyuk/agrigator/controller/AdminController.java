//package com.kirilyuk.agrigator.controller;
//
//import com.kirilyuk.agrigator.entities.Product;
//import com.kirilyuk.agrigator.service.ProductService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/adminPage")
//public class AdminController {
//    private final ProductService service;
//
//    public AdminController(ProductService service) {
//        this.service = service;
//    }
//
//    @GetMapping("/allProd")
//    public void getAll(){
//        service.getAllProducts();
//    }
//
//    @PostMapping("/save")
//    public void saveProduct(@RequestBody List<Product> product) {
//
//        service.saveProduct(product);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteProduct(@PathVariable("id") Long id) {
//
//        service.deleteProduct(id);
//
//        return "Product with ID=" + id + " was deleted";
//    }
//
//    @DeleteMapping("/clean")
//    public void deleteAllProducts() {
//
//        service.deleteAllProducts();
//    }
//
//    /**
//     *for Admin
//     *  /save                - добавить продукт
//     *  /delete/{id}         - удалить продукт
//     *  /clean               - отчистить базу данных
//     */
//}
