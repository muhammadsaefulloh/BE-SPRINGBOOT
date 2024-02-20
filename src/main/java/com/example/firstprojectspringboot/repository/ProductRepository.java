package com.example.firstprojectspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.firstprojectspringboot.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT p.name FROM Product p")
    List<String> findAllNames();
}
