package org.example.orem.domain.orem.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.orem.domain.orem.dto.ResponseOremAndPlantByBirth;
import org.example.orem.domain.orem.dto.ResponseOremBySeason;
import org.example.orem.domain.orem.entity.EntireOrem;
import org.example.orem.domain.orem.entity.Orem;
import org.example.orem.domain.orem.repository.EntireOremRepository;
import org.example.orem.domain.orem.repository.OremRepository;
import org.example.orem.domain.plant.dto.PlantResponse;
import org.example.orem.domain.plant.service.PlantService;
import org.example.orem.global.utils.AdjectiveGenerator;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OremService {

    private final OremRepository oremRepository;
    private final EntireOremRepository entireOremRepository;
    private final PlantService plantService;

    // 1. 형용사,
    // 2. 식물
    // 3. 오름
    public ResponseOremAndPlantByBirth suggestOremByBirth(int month, int day) {
        int idx = 30 * (month - 1) + day;
        EntireOrem entireOrem = entireOremRepository.findById((long) idx).orElseThrow();
        PlantResponse plantResponse = plantService.getPlantByBirth(month);
        return ResponseOremAndPlantByBirth.builder()
            .adjective(AdjectiveGenerator.get())
            .oremName(entireOrem.getName())
            .plantResponse(plantResponse)
            .build();
    }

    public ResponseOremBySeason recommendedBySeason(String season){
        long length = oremRepository.count();
        long idx = generateIdx(length);
        Orem orem =  oremRepository.findById(idx).orElseThrow();

        return ResponseOremBySeason.builder()
            .name(orem.getName())
            .city(orem.getCity())
            .placeUrl(orem.getPlaceUrl())
            .keywords(convertToList(orem.getKeyword()))
            .imageUrl(orem.getImageUrl())
            .description(orem.getDescription())
            .build();

    }

    private List<String> convertToList(String keyword) {
        return Arrays.asList(keyword.split(","));
    }

    private long generateIdx(long maxSize) {
        Random random = new Random();
        return random.nextLong(maxSize) + 1;
    }

}
