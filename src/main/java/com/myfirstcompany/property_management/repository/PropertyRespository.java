package com.myfirstcompany.property_management.repository;

import com.myfirstcompany.property_management.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRespository extends CrudRepository<PropertyEntity, Long> {
}
