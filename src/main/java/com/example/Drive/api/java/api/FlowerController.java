package com.example.Drive.api.java.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Drive.api.java.model.Flower;
import com.example.Drive.api.java.service.FlowerService;

import java.util.List;

@RequestMapping("api/v1")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FlowerController {
    @Autowired
    FlowerService flowerService;

    @GetMapping("/get/all/flower")
    public ResponseEntity<List<Flower>> getAllFlower(){
        List<Flower> flower = flowerService.getAllFlower();
        return ResponseEntity.ok(flower);
    }

}
