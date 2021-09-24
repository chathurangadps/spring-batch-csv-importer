package com.example.batch.csv.importer.config;

import com.example.batch.csv.importer.dto.EmployeeDto;
import com.example.batch.csv.importer.entity.EmployeeEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Slf4j
@Configuration
public class ItemProcessorConfig implements ItemProcessor<EmployeeDto , EmployeeEntity> {

    @Override
    public EmployeeEntity process(EmployeeDto employeeDto) throws Exception {
        log.info("PROCESSING EMPLOYEE : " .concat(employeeDto.getName()));
        return employeeDto.toEntity(EmployeeEntity.class);
    }
}
