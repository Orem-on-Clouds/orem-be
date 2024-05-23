package org.example.orem.global.csv;


import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.orem.domain.plant.entity.Plant;
import org.example.orem.domain.plant.entity.Season;
import org.example.orem.domain.plant.repository.PlantRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class PlantCsvWriter implements ItemWriter<PlantCSVDto> {

    private final PlantRepository plantRepository;
    @Override
    public void write(Chunk<? extends PlantCSVDto> chunk) throws Exception {
        log.info("[Write] Insert Plant CSV to DB");
        List<Plant> plants = new ArrayList<>();
        chunk.forEach(dto ->{
            log.info("");
            Plant plant = Plant.builder()
                .plantName(dto.getPlantName())
                .scientificName(dto.getScientificName())
                .familyName(dto.getFamilyName())
                .nameOrigin(dto.getNameOrigin())
                .plantingLocation(dto.getPlantingLocation())
                .distribution(dto.getDistribution())
                .floweringPeriod(Season.of(dto.getFloweringPeriod()))
                .height(dto.getHeight())
                .leafCharacteristics(dto.getLeafCharacteristics())
                .bloomingSeason(dto.getBloomingSeason())
                .bloomingDetails(dto.getBloomingDetails())
                .stemCharacteristics(dto.getStemCharacteristics())
                .hardiness(dto.getHardiness())
                .utilization(dto.getUtilization())
                .imageUrl(dto.getImage_url())
                .description(dto.getDescription())
                .build();
            plants.add(plant);
        });

        plantRepository.saveAll(plants);
    }
}
