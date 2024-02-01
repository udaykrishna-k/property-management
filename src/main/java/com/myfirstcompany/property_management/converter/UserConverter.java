package com.myfirstcompany.property_management.converter;

import com.myfirstcompany.property_management.dto.UserDTO;
import com.myfirstcompany.property_management.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity convertDTOtoEntity(UserDTO userDTO){
        UserEntity ue = new UserEntity();
        ue.setPhone(userDTO.getPhone());
        ue.setPassword(userDTO.getPassword());
        ue.setOwnerName(userDTO.getOwnerName());
        ue.setOwnerEmail(userDTO.getOwnerEmail());
        return ue;
    }

    public UserDTO convertEntitytoDTO(UserEntity ue){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(ue.getId());
        userDTO.setPhone(ue.getPhone());
        userDTO.setOwnerName(ue.getOwnerName());
        userDTO.setOwnerEmail(ue.getOwnerEmail());
        return userDTO;
    }
}
