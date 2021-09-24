package com.example.batch.csv.importer.common;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class IdProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
