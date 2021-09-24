package com.example.batch.csv.importer.config;

import com.example.batch.csv.importer.dao.EmployeeRepository;
import com.example.batch.csv.importer.entity.EmployeeEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Configuration
public class ItemWriterConfig implements ItemWriter<EmployeeEntity> {

    private final EmployeeRepository employeeRepository;

    public ItemWriterConfig(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void write(List<? extends EmployeeEntity> list) throws Exception {
        log.info("SAVING EMPLOYEES TO THE DATABASE");
        employeeRepository.saveAll(list);
    }
}
