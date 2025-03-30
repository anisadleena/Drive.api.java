package com.example.Drive.api.java.repository;

import com.example.Drive.api.java.model.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerRepository extends JpaRepository<Flower, String> {
}
