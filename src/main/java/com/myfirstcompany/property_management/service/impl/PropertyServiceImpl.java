package com.myfirstcompany.property_management.service.impl;

import com.myfirstcompany.property_management.converter.PropertyConverter;
import com.myfirstcompany.property_management.dto.PropertyDTO;
import com.myfirstcompany.property_management.entity.PropertyEntity;
import com.myfirstcompany.property_management.entity.UserEntity;
import com.myfirstcompany.property_management.exception.BusinessException;
import com.myfirstcompany.property_management.exception.ErrorModel;
import com.myfirstcompany.property_management.repository.PropertyRespository;
import com.myfirstcompany.property_management.repository.UserRepository;
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
    @Autowired
    private UserRepository userRepository;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        Optional<UserEntity> optue = userRepository.findById(propertyDTO.getUserId());
        PropertyDTO dto = null;
        if (optue.isPresent()) {
            PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);
            pe.setUserEntity(optue.get());
            pe = propertyRespository.save(pe);
            dto = propertyConverter.convertEntitytoDTO(pe);
        }
        else{
            ErrorModel errorModel = new ErrorModel();
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModel.setCode("USER_DOES_NOT_EXIST");
            errorModel.setMessage("user is not found in the database");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
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
    public List<PropertyDTO> getAllPropertiesForUser(Long userId) {
        List<PropertyEntity> listPropertyEntity = (List<PropertyEntity>)propertyRespository.findAllByUserEntityId(userId);
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
             pe.setUserEntity(optionalPe.get().getUserEntity());
             pe.setId(id);
             dto = propertyConverter.convertEntitytoDTO(pe);
             propertyRespository.save(pe);
         }
         else{
             ErrorModel errorModel = new ErrorModel();
             List<ErrorModel> errorModelList = new ArrayList<>();
             errorModel.setCode("PROPERTY_NOT_FOUND");
             errorModel.setMessage("failed to update property information");
             errorModelList.add(errorModel);
             throw new BusinessException(errorModelList);
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
