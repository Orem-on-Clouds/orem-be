package org.example.orem.domain.plant.service;

import lombok.RequiredArgsConstructor;
import org.example.orem.domain.plant.dto.PlantResponse;
import org.example.orem.domain.plant.entity.Plant;
import org.example.orem.domain.plant.repository.PlantRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlantService {

    private final PlantRepository plantRepository;

    public PlantResponse getPlantByBirth(int requestMonth) {
        Plant plant = plantRepository.findByBloomingSeason(requestMonth).orElseThrow();
        return PlantResponse.builder()
            .plantName(plant.getPlantName())
            .bloomingSeason(plant.getBloomingSeason())
            .distribution(plant.getDistribution())
            .floweringPeriod(plant.getFloweringPeriod().getValue())
            .height(plant.getHeight())
            .desc(plant.getDesc())
            .imageUrl(plant.getImageUrl())
            .build();

    }
}
