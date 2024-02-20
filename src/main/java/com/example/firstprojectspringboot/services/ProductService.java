package com.example.firstprojectspringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.firstprojectspringboot.models.Product;
import com.example.firstprojectspringboot.repository.ProductRepository;

import io.micrometer.common.util.StringUtils;



@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    // public Product save(Product product) {
    //     // return productRepository.save(product);
    //     if (isValidProduct(product)) {
    //         return productRepository.save(product);
    //     } else {
    //         throw new IllegalArgumentException("Invalid product data ya");
            
    //     }
    // }
     public ResponseEntity<Object> save(Product product) {
        if (isValidProduct(product)) {
            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid product data", HttpStatus.BAD_REQUEST);
        }
    }
    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }
    public Optional<Product> findOne(Long id){
        return productRepository.findById(id);
    }
    public void dropProduct(Long id){
        productRepository.deleteById(id);
    }
    private boolean isValidProduct(Product product) {
        return isAlphanumeric(product.getName()) && isAlphanumeric(product.getDescription());
    }
    private boolean isAlphanumeric(String input) {
        return StringUtils.isNotBlank(input) && input.matches("^[a-zA-Z0-9 ]+$");
    }
    public List<String> findAllProductNames() {
        return productRepository.findAllNames();
    }
}
