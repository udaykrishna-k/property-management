package com.myfirstcompany.property_management.converter;

import com.myfirstcompany.property_management.dto.PropertyDTO;
import com.myfirstcompany.property_management.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component

public class PropertyConverter {
    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO){
        PropertyEntity pe = new PropertyEntity();
        pe.setAddress(propertyDTO.getAddress());
        pe.setTitle(propertyDTO.getTitle());
        pe.setPrice(propertyDTO.getPrice());
        return pe;
    }

    public PropertyDTO convertEntitytoDTO(PropertyEntity propertyEntity){
        PropertyDTO dto = new PropertyDTO();
        dto.setId(propertyEntity.getId());
        dto.setAddress(propertyEntity.getAddress());
        dto.setTitle(propertyEntity.getTitle());
        dto.setPrice(propertyEntity.getPrice());
        dto.setUserId(propertyEntity.getUserEntity().getId());
        return dto;
    }
}
