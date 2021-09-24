package com.example.batch.csv.importer.common;

import org.springframework.beans.BeanUtils;

public interface EntityDtoConvertable {

     default  <T> T toDto(Class<T> type) {
         T dto = BeanUtils.instantiateClass(type);
         BeanUtils.copyProperties(this , dto);
         return dto;
    }

    default <T> T toEntity(Class<T> type){

        T entity = BeanUtils.instantiateClass(type);
        BeanUtils.copyProperties(this , entity);
        return entity;
    }
}
