package com.example.batch.csv.importer.controller;

import com.example.batch.csv.importer.dto.EmployeeDto;
import com.example.batch.csv.importer.entity.EmployeeEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setAge("1");
        employeeEntity.setDept("001");
        employeeEntity.setName("A");
        employeeEntity.setSalary(new BigDecimal(10000));


        EmployeeDto employeeDto = employeeEntity.toDto(EmployeeDto.class);

        System.out.println("employeeDto : " + employeeDto);

        return "Test>>>>>done";
    }
}
