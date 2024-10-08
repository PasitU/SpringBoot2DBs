package com.example.thisbetterwork.services;

import com.example.thisbetterwork.repositories.entities.Product;
import com.example.thisbetterwork.repositories.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
