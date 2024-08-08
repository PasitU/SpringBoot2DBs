package com.example.thisbetterwork.repositories.repo;

import com.example.thisbetterwork.repositories.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {
}
