package com.myfirstcompany.property_management.service.impl;

import com.myfirstcompany.property_management.converter.UserConverter;
import com.myfirstcompany.property_management.dto.UserDTO;
import com.myfirstcompany.property_management.entity.UserEntity;
import com.myfirstcompany.property_management.exception.BusinessException;
import com.myfirstcompany.property_management.exception.ErrorModel;
import com.myfirstcompany.property_management.repository.UserRepository;
import com.myfirstcompany.property_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity> optue = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(optue.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel error = new ErrorModel();
            error.setCode("USER_EXISTS");
            error.setMessage("email is already in use");
            errorModelList.add(error);
            throw new BusinessException(errorModelList);
        }
        UserEntity ue = userConverter.convertDTOtoEntity(userDTO);
        ue = userRepository.save(ue);
        userDTO = userConverter.convertEntitytoDTO(ue);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDto = null;
        Optional<UserEntity> optue = userRepository.findByOwnerEmailAndPassword(email, password);
        if (optue.isPresent()){
            userDto = userConverter.convertEntitytoDTO(optue.get());
        }
        else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel error = new ErrorModel();
            error.setCode("INVALID_USER");
            error.setMessage("wrong email or password");
            errorModelList.add(error);
            throw new BusinessException(errorModelList);
        }
        return userDto;
    }
}
