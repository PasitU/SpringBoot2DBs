package com.example.thisbetterwork.repositories2.repo;

import com.example.thisbetterwork.repositories2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Integer> {


}
