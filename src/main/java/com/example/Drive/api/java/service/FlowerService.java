package com.example.Drive.api.java.service;
import com.example.Drive.api.java.model.Flower;
import com.example.Drive.api.java.repository.FlowerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerService {
    @Autowired
    FlowerRepository flowerRepository;

    public List<Flower> getAllFlower(){
        List<Flower> flowerList = null;
        flowerList = flowerRepository.findAll();
        System.out.println("flowerList : " + flowerList);

        return flowerList;
    }
}
