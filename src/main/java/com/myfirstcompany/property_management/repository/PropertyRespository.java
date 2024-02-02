package com.myfirstcompany.property_management.repository;

import com.myfirstcompany.property_management.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PropertyRespository extends CrudRepository<PropertyEntity, Long> {
    List<PropertyEntity> findAllByUserEntityId(Long userId);
}
