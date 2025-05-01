package com.example.Drive.api.java.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Drive.api.java.model.User;
import com.example.Drive.api.java.service.UserService;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        String result = userService.signup(user);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        String jwt = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (jwt.equals("Invalid credentials") || jwt.equals("User not found")) {
            return ResponseEntity.status(401).body(Map.of("error", jwt));
        }
        return ResponseEntity.ok(Map.of("token", jwt));
    }
}
