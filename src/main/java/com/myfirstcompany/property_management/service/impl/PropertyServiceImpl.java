package com.myfirstcompany.property_management.service.impl;

import com.myfirstcompany.property_management.converter.PropertyConverter;
import com.myfirstcompany.property_management.dto.PropertyDTO;
import com.myfirstcompany.property_management.entity.PropertyEntity;
import com.myfirstcompany.property_management.repository.PropertyRespository;
import com.myfirstcompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRespository propertyRespository;
    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);
        pe = propertyRespository.save(pe);
        PropertyDTO dto = propertyConverter.convertEntitytoDTO(pe);
        return dto;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> listPropertyEntity = (List<PropertyEntity>)propertyRespository.findAll();
        List<PropertyDTO> listPropertyDto = new ArrayList<>();
        for(PropertyEntity pe : listPropertyEntity){
            listPropertyDto.add(propertyConverter.convertEntitytoDTO(pe));
        }
        return listPropertyDto;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long id) {
         Optional<PropertyEntity> optionalPe = propertyRespository.findById(id);
         PropertyDTO dto = null;
         if (optionalPe.isPresent()){
             PropertyEntity pe = optionalPe.get();
             pe = propertyConverter.convertDTOtoEntity(propertyDTO);
             pe.setId(id);
             dto = propertyConverter.convertEntitytoDTO(pe);
             propertyRespository.save(pe);
         }
         return dto;
    }

    @Override
    public PropertyDTO updatePrice(PropertyDTO propertyDTO, Long id) {
        Optional<PropertyEntity> optionalPe = propertyRespository.findById(id);
        PropertyDTO dto = null;
        if (optionalPe.isPresent()){
            PropertyEntity pe = optionalPe.get();
            pe.setPrice(propertyDTO.getPrice());
            dto = propertyConverter.convertEntitytoDTO(pe);
            propertyRespository.save(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long id) {
        propertyRespository.deleteById(id);
    }
}
