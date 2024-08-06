package com.example.thisbetterwork.controllers;

import com.example.thisbetterwork.repositories.ProductRepository;
import com.example.thisbetterwork.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
