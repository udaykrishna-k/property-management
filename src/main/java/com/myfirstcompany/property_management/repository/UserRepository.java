package com.myfirstcompany.property_management.repository;

import com.myfirstcompany.property_management.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
