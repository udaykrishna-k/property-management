package com.myfirstcompany.property_management.service;

import com.myfirstcompany.property_management.dto.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);
    UserDTO login(UserDTO userDTO);
}
