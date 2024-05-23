package org.example.orem.domain.plant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plantName;

    private String scientificName;
    private String familyName;
    private String nameOrigin;

    private String plantingLocation;
    private String distribution;
    private Season floweringPeriod;
    private String height;
    private String leafCharacteristics;
    private int bloomingSeason;
    private String bloomingDetails;
    private String stemCharacteristics;
    private String hardiness;
    private String utilization;
    @Column(name="image_url")
    private String imageUrl;
    private String desc;


    @Builder
    public Plant(String plantName, String scientificName, String familyName, String nameOrigin,
        String plantingLocation, String distribution, Season floweringPeriod, String height,
        String leafCharacteristics, int bloomingSeason, String bloomingDetails,
        String stemCharacteristics, String hardiness, String utilization, String imageUrl,
        String desc) {
        this.plantName = plantName;
        this.scientificName = scientificName;
        this.familyName = familyName;
        this.nameOrigin = nameOrigin;
        this.plantingLocation = plantingLocation;
        this.distribution = distribution;
        this.floweringPeriod = floweringPeriod;
        this.height = height;
        this.leafCharacteristics = leafCharacteristics;
        this.bloomingSeason = bloomingSeason;
        this.bloomingDetails = bloomingDetails;
        this.stemCharacteristics = stemCharacteristics;
        this.hardiness = hardiness;
        this.utilization = utilization;
        this.imageUrl = imageUrl;
        this.desc = desc;
    }
}
