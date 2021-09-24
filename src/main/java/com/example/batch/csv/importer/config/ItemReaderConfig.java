package com.example.batch.csv.importer.config;

import com.example.batch.csv.importer.dto.EmployeeDto;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ItemReaderConfig {

    @Bean
    public FlatFileItemReader<EmployeeDto> flatFileItemReader(@Value("${input.file}") Resource resource){

        FlatFileItemReader<EmployeeDto> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(resource);
        flatFileItemReader.setName("CSV-IMPORTER");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(lineMapper());

        return flatFileItemReader;
    }

    @Bean
    public LineMapper<EmployeeDto> lineMapper(){

        DefaultLineMapper<EmployeeDto> employeeDtoDefaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        delimitedLineTokenizer.setDelimiter(",");
        delimitedLineTokenizer.setStrict(false);
        delimitedLineTokenizer.setNames("id","name","age","dept","salary");

        BeanWrapperFieldSetMapper<EmployeeDto> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(EmployeeDto.class);

        employeeDtoDefaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
        employeeDtoDefaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

        return employeeDtoDefaultLineMapper;
    }
}
