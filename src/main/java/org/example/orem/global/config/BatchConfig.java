package org.example.orem.global.config;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.orem.global.csv.EntireOremCsvDto;
import org.example.orem.global.csv.EntireOremCsvReader;
import org.example.orem.global.csv.EntireOremCsvWriter;
import org.example.orem.global.csv.OremCSVDto;
import org.example.orem.global.csv.OremCsvReader;
import org.example.orem.global.csv.OremCsvWriter;
import org.example.orem.global.csv.PlantCSVDto;
import org.example.orem.global.csv.PlantCSVReader;
import org.example.orem.global.csv.PlantCsvWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class BatchConfig {

    private final OremCsvReader oremCsvReader;
    private final OremCsvWriter oremCsvWriter;
    private final PlantCSVReader plantCsvReader;
    private final PlantCsvWriter plantCsvWriter;
    private final EntireOremCsvReader entireOremCsvReader;
    private final EntireOremCsvWriter entireOremCsvWriter;

    private final PlatformTransactionManager transactionManager;

    private static final int chunkSize = 50;

    @Bean
    public Job csvFileToDBJob(JobRepository jobRepository, Step oremCsvFileItemReaderStep,
        Step plantCsvFileItemReaderStep, Step entireOremFileItemReaderStep) {
        return new JobBuilder("csvFileToDBJob", jobRepository)
            .start(oremCsvFileItemReaderStep)
            .next(plantCsvFileItemReaderStep)
            .next(entireOremFileItemReaderStep)
            .build();
    }

    @Bean
    public Step oremCsvFileItemReaderStep(JobRepository jobRepository) {
        return new StepBuilder("oremCsvFileItemReaderStep", jobRepository)
            .<OremCSVDto, OremCSVDto>chunk(chunkSize, transactionManager)
            .reader(oremCsvReader.oremCsvFileItemReader())
            .writer(oremCsvWriter)
            .allowStartIfComplete(Boolean.TRUE)
            .build();
    }


    @Bean
    public Step plantCsvFileItemReaderStep(JobRepository jobRepository) {
        log.info("[PLANT WRITE]");
        return new StepBuilder("plantCsvFileItemReaderStep", jobRepository)
            .<PlantCSVDto, PlantCSVDto>chunk(chunkSize, transactionManager)
            .reader(plantCsvReader.plantCsvFileItemReader())
            .writer(plantCsvWriter)
            .allowStartIfComplete(Boolean.TRUE)
            .build();
    }

    @Bean
    public Step entireOremFileItemReaderStep(JobRepository jobRepository) {
        return new StepBuilder("entireOremFileItemReaderStep", jobRepository)
            .<EntireOremCsvDto, EntireOremCsvDto>chunk(chunkSize+100, transactionManager)
            .reader(entireOremCsvReader.entireOremCsvDtoFlatFileItemReader())
            .writer(entireOremCsvWriter)
            .allowStartIfComplete(Boolean.TRUE)
            .build();
    }

}
