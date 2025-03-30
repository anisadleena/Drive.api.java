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

    public Flower createFlower(Flower flowerBody){
        Flower newFlower = new Flower();
        newFlower.setName(flowerBody.getName());
        newFlower.setDescription(flowerBody.getDescription());
        newFlower.setPrice(flowerBody.getPrice());
        newFlower.setImageUrl(flowerBody.getImageUrl());
        newFlower.setType(flowerBody.getType());
        newFlower.setScientificName(flowerBody.getScientificName());
        newFlower.setColor(flowerBody.getColor());
        newFlower.setBloomSeason(flowerBody.getBloomSeason());
        newFlower.setNativeRegion(flowerBody.getNativeRegion());
        newFlower.setSunlightRequirement(flowerBody.getSunlightRequirement());
        newFlower.setWaterRequirement(flowerBody.getWaterRequirement());
        newFlower.setStockQuantity(flowerBody.getStockQuantity());
        newFlower.setAddedDate(flowerBody.getAddedDate());
        

        try {
            newFlower = flowerRepository.save(newFlower);
            System.out.println("TimeSheet created successfully: " + newFlower);
        } catch (Exception e) {
            System.out.println("Failed to create TimeSheet");
            e.printStackTrace();
            throw e; 
        }

        System.out.println("newTimeSheet :: "+ newFlower);
        flowerRepository.save(newFlower);
        return newFlower;
    }
    
    public Optional<Flower> deleteFlowerById(String id){
        Optional<Flower> deleteflowerByid = null;
        deleteflowerByid = flowerRepository.findById(id);
        flowerRepository.delete(deleteflowerByid.get());
        return deleteflowerByid;
    }
}
