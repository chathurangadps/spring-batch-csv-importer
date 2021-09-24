package com.example.batch.csv.importer.entity;

import com.example.batch.csv.importer.common.property.EmployeeProperty;
import com.example.batch.csv.importer.common.EntityDtoConvertable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Table(name = "employee")
@Entity
@EqualsAndHashCode(callSuper = true)
public class EmployeeEntity extends EmployeeProperty implements EntityDtoConvertable {

}
