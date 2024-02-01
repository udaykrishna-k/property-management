package com.myfirstcompany.property_management.service;

import com.myfirstcompany.property_management.dto.PropertyDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {
    public PropertyDTO saveProperty(PropertyDTO propertyDTO);
    public List<PropertyDTO> getAllProperties();
    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long id);
    PropertyDTO updatePrice(PropertyDTO propertyDTO, Long id);
    void deleteProperty(Long id);
}
