package org.example.orem.global.csv;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OremCSVDto {
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
}
