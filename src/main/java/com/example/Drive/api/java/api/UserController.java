package com.example.Drive.api.java.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Drive.api.java.model.User;
import com.example.Drive.api.java.service.UserService;

import java.util.List;

@RequestMapping("api/v1")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/get/user")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> user = userService.getAllUser();
        return ResponseEntity.ok(user);
    }

}
