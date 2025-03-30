package com.example.Drive.api.java.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "flower")
@Getter
@Setter
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "type")
    private String type;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "scientific_name")
    private String scientificName;

    @Column(name = "color")
    private String color;

    @Column(name = "bloom_season")
    private String bloomSeason;

    @Column(name = "native_region")
    private String nativeRegion;

    @Column(name = "sunlight_requirement")
    private String sunlightRequirement;

    @Column(name = "water_requirement")
    private String waterRequirement;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    @Column(name = "added_date", updatable = false)
    private LocalDateTime addedDate = LocalDateTime.now();

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @PreUpdate
    public void setUpdatedDate() {
        this.updatedDate = LocalDateTime.now();
    }
}
