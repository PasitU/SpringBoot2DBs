package com.example.thisbetterwork.repositories.repo;

import com.example.thisbetterwork.repositories.enitities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProductRepository extends JpaRepository<Product, Integer> {
}
