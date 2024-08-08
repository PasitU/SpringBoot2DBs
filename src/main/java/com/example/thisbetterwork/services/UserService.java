package com.example.thisbetterwork.services;

import com.example.thisbetterwork.repositories2.entities.User;
import com.example.thisbetterwork.repositories2.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
