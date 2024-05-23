package org.example.orem.global.csv;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.orem.domain.orem.entity.EntireOrem;
import org.example.orem.domain.orem.repository.EntireOremRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
@RequiredArgsConstructor
public class EntireOremCsvWriter implements ItemWriter<EntireOremCsvDto> {

    private final EntireOremRepository oremRepository;
    @Override
    public void write(Chunk<? extends EntireOremCsvDto> chunk) throws Exception {
        List<EntireOrem> eOrems = new ArrayList<>();
        chunk.forEach(dto ->{
            EntireOrem entireOrem = EntireOrem.builder()
                .name(dto.getPlaceName())
                .build();
            eOrems.add(entireOrem);
        });

        oremRepository.saveAll(eOrems);
    }
}
