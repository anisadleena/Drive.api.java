package com.example.Drive.api.java.service;
import com.example.Drive.api.java.model.User;
import com.example.Drive.api.java.repository.UserRepository;
import com.example.Drive.api.java.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private JwtUtil jwtUtil;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public String signup(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "Email already in use";
        }

        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user); 
        return "User registered successfully";
    }

    public String login(String email, String rawPassword) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        
        if (optionalUser.isEmpty()) {
            return "User not found";
        }
    
        User user = optionalUser.get();
    
        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            return "Invalid credentials";
        }
    
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("username", user.getUsername());
        claims.put("email", user.getEmail());
        claims.put("phone", user.getPhone());
    
        return jwtUtil.generateToken(claims, user.getEmail());
    }
    
}
