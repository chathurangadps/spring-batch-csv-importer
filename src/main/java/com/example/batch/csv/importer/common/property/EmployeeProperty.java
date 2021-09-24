package com.example.batch.csv.importer.common.property;

import com.example.batch.csv.importer.common.IdProperty;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

@Data
@MappedSuperclass
public class EmployeeProperty extends IdProperty {

    private String name;

    private String  age;

    private String dept;

    private BigDecimal salary;
}
