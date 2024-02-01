package com.myfirstcompany.property_management.controller;

import com.myfirstcompany.property_management.dto.UserDTO;
import com.myfirstcompany.property_management.entity.UserEntity;
import com.myfirstcompany.property_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO){
        userDTO = userService.register(userDTO);
        ResponseEntity<UserDTO> responseEntity = new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        return responseEntity;
    }
}
