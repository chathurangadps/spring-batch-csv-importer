package com.example.batch.csv.importer.dto;

import com.example.batch.csv.importer.common.property.EmployeeProperty;
import com.example.batch.csv.importer.common.EntityDtoConvertable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class EmployeeDto extends EmployeeProperty implements EntityDtoConvertable {

}
