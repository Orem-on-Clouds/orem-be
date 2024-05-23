package org.example.orem.global.csv;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlantCSVDto {
    private String plantName;
    private String scientificName;
    private String familyName;
    private String nameOrigin;
    private String plantingLocation;
    private String distribution;
    private String floweringPeriod;
    private String height;
    private String leafCharacteristics;
    private int bloomingSeason;
    private String bloomingDetails;
    private String stemCharacteristics;
    private String hardiness;
    private String utilization;
    private String image_url;
    private String desc;
}
