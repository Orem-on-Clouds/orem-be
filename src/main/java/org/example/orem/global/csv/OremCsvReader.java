package org.example.orem.global.csv;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class OremCsvReader {

    @Bean
    public FlatFileItemReader<OremCSVDto> oremCsvFileItemReader() {
        log.info("[READER] START!!");
        /* file read */
        FlatFileItemReader<OremCSVDto> flatFileItemReader = new FlatFileItemReader<>();
//        flatFileItemReader.setResource(new ClassPathResource("/csv/food.csv"));
        flatFileItemReader.setResource(new ClassPathResource("/csv/orem.csv"));
        flatFileItemReader.setLinesToSkip(1); // header line skip
        flatFileItemReader.setEncoding("UTF-8"); // encoding

        /* read하는 데이터를 내부적으로 LineMapper을 통해 Mapping */
        DefaultLineMapper<OremCSVDto> defaultLineMapper = new DefaultLineMapper<>();

        /* delimitedLineTokenizer : setNames를 통해 각각의 데이터의 이름 설정 */
        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer(",");
//        delimitedLineTokenizer.setNames("id", "name");
        delimitedLineTokenizer.setNames("name", "city", "location", "addressJibun", "longitude",
            "latitude", "placeUrl", "keywords", "imageUrl", "description");
        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);

        /* beanWrapperFieldSetMapper : Tokenizer에서 가지고온 데이터들을 VO로 바인드하는 역할 */
        BeanWrapperFieldSetMapper<OremCSVDto> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(OremCSVDto.class);

        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

        /* lineMapper 지정 */
        flatFileItemReader.setLineMapper(defaultLineMapper);

        return flatFileItemReader;
    }
}
