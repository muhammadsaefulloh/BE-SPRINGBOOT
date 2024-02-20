package com.example.firstprojectspringboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstprojectspringboot.models.Product;
import com.example.firstprojectspringboot.services.ProductService;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/api/product")
public class TestController {
    @Autowired
    private ProductService productService;

    @GetMapping("/test")
    public String HelloWord() {
        return "test";
    }
    @GetMapping("/all")
    public Iterable<Product> getAllProducts() {
        return productService.findAll();
    }
    @PostMapping("/create")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public void dropProduct(@PathVariable Long id){
        productService.dropProduct(id);
    }

    @GetMapping("/get-one/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.findOne(id);
    }
    @GetMapping("/get-all-name")
    public List<String> findAllProductNames() {
        return productService.findAllProductNames();
    }
    
    
    // private List<String> products = new ArrayList<>();
    // @GetMapping
    // public List<String> getAllUsers() {
    //     return products;
    // }
    // @PostMapping
    // public String createUser(@RequestBody String product) {
    //     products.add(product);
    //     return "User created: " + product;
    // }
    // @DeleteMapping("/{user}")
    // public String deleteUser(@PathVariable String user) {
    //     if (users.contains(user)) {
    //         users.remove(user);
    //         return "User deleted: " + user;
    //     }
    //     return "User not found";
    // }
    
    
}
