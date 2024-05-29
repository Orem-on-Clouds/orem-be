package org.example.orem.global.csv;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.orem.domain.orem.entity.Orem;
import org.example.orem.domain.orem.repository.OremRepository;
import org.example.orem.global.csv.dto.OremCSVDto;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class OremCsvWriter implements ItemWriter<OremCSVDto> {

    private final OremRepository oremRepository;

    @Override
    public void write(Chunk<? extends OremCSVDto> chunk) throws Exception {
        List<Orem> orems = new ArrayList<>();
        chunk.forEach(oremCSVDTO -> {
            Orem orem = Orem.builder()
                .name(oremCSVDTO.getName())
                .city(oremCSVDTO.getCity())
                .location(oremCSVDTO.getLocation())
                .address(oremCSVDTO.getAddress())
                .latitude(oremCSVDTO.getLongitude())
                .longitude(oremCSVDTO.getLongitude())
                .placeUrl(oremCSVDTO.getPlaceUrl())
                .keyword(oremCSVDTO.getKeyword())
                .imageUrl(oremCSVDTO.getImageUrl())
                .description(oremCSVDTO.getDescription())
                .season(oremCSVDTO.getSeason())
                .build();
            orems.add(orem);
        });

        oremRepository.saveAll(orems);
    }

}

