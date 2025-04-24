package com.example.Drive.api.java.service;
import com.example.Drive.api.java.model.User;
import com.example.Drive.api.java.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public String signup(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "Email already in use";
        }
        userRepository.save(user); 
        return "User registered successfully";
    }

    public String login(String email, String rawPassword) {
        return userRepository.findByEmail(email)
            .map(user -> {
                if (rawPassword.equals(user.getPassword())) {
                    return "Login successful";
                } else {
                    return "Invalid credentials";
                }
            })
            .orElse("User not found");
    }
}
