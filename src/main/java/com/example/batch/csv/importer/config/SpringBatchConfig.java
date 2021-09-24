package com.example.batch.csv.importer.config;

import com.example.batch.csv.importer.dto.EmployeeDto;
import com.example.batch.csv.importer.entity.EmployeeEntity;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig extends DefaultBatchConfigurer {

    @Value("${step.chunk}")
    private int stepChunk;

    @Bean
    public Job job (JobBuilderFactory jobBuilderFactory ,
                    StepBuilderFactory stepBuilderFactory,
                    ItemReader<EmployeeDto> itemReader,
                    ItemProcessor<EmployeeDto , EmployeeEntity> itemProcessor,
                    ItemWriter<EmployeeEntity> itemWriter){

        Step step = stepBuilderFactory.get("ETL-FILE-LOAD")
                .<EmployeeDto , EmployeeEntity>chunk(stepChunk)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();

        return jobBuilderFactory.get("ETL-LOAD")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }
}

