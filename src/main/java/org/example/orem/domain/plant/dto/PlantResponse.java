package org.example.orem.domain.plant.dto;

import lombok.Builder;
import org.example.orem.domain.plant.entity.Season;

@Builder
public record PlantResponse(
    String plantName,
    int bloomingSeason,
    String distribution,
    String floweringPeriod,
    String height,
    String description,
    String imageUrl
    ) {

}
