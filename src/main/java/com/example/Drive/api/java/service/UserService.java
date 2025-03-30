package com.example.Drive.api.java.service;
import com.example.Drive.api.java.model.User;
import com.example.Drive.api.java.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUser(){
        List<User> userList = null;
        userList = userRepository.findAll();
        System.out.println("userList : " + userList);

        return userList;
    }
}
