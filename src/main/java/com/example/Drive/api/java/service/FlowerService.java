package com.example.Drive.api.java.service;
import com.example.Drive.api.java.model.Flower;
import com.example.Drive.api.java.repository.FlowerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Flower> getAllFlowerByID(String id){
        Optional<Flower> timesheetByID = null;
        timesheetByID = flowerRepository.findById(id);
        System.out.println("statusList : " + timesheetByID);

        return timesheetByID;
    }

    public Optional<Flower> deleteFlowerById(String id){
        Optional<Flower> deleteflowerByid = null;
        deleteflowerByid = flowerRepository.findById(id);
        flowerRepository.delete(deleteflowerByid.get());
        return deleteflowerByid;
    }
}
