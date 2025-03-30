package com.example.Drive.api.java.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Drive.api.java.model.Flower;
import com.example.Drive.api.java.service.FlowerService;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/get/flower/{Id}")
    public ResponseEntity<Optional<Flower>> getAllFlowerByID(@PathVariable("Id") String id){
        Optional<Flower> timesheet = flowerService.getAllFlowerByID(id);
        return ResponseEntity.ok(timesheet);
    }

    @PostMapping("/create/flower")
    public ResponseEntity<Flower> createTimeSheet(@RequestBody Flower flower){
        Flower createdFlower = flowerService.createFlower(flower);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlower);
    }

    @DeleteMapping("/delete/flower/{Id}")
    public ResponseEntity<Optional<Flower>> deleteFlowerById(@PathVariable("Id") String id){
        Optional<Flower> timesheet = flowerService.deleteFlowerById(id);
        return ResponseEntity.ok(timesheet);
    }
}
