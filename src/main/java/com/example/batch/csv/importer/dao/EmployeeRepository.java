package com.example.batch.csv.importer.dao;

import com.example.batch.csv.importer.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity , Integer> {

}
