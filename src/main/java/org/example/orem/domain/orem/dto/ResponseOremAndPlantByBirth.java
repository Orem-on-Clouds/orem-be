package org.example.orem.domain.orem.dto;

import lombok.Builder;
import org.example.orem.domain.plant.dto.PlantResponse;

@Builder
public record ResponseOremAndPlantByBirth(
    String adjective,
    String oremName,
    PlantResponse plantResponse
) {

}
