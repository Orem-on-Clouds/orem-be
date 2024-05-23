package org.example.orem.domain.orem.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Orem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String city;
    private String location;
    private String address;

    private Double longitude;

    private Double latitude;

    private String placeUrl;

    private String keyword;
    private String imageUrl;
    private String desc;

    @Builder
    public Orem(String name, String city, String location, String address, Double longitude,
        Double latitude, String placeUrl, String keyword, String imageUrl, String desc) {
        this.name = name;
        this.city = city;
        this.location = location;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.placeUrl = placeUrl;
        this.keyword = keyword;
        this.imageUrl = imageUrl;
        this.desc = desc;
    }

}
