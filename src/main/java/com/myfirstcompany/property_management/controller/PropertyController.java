package com.myfirstcompany.property_management.controller;
import com.myfirstcompany.property_management.dto.PropertyDTO;
import com.myfirstcompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

//    http://localhost:8080/api/v1/properties
    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> save(@RequestBody PropertyDTO propertyDTO){
        propertyDTO = propertyService.saveProperty(propertyDTO);
        return new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.CREATED);
    }

//    http://localhost:8080/api/v1/properties
    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
        List<PropertyDTO> listDTO = propertyService.getAllProperties();
        return new ResponseEntity<List<PropertyDTO>>(listDTO, HttpStatus.OK);
    }

    //    http://localhost:8080/api/v1/properties/{id}
    @GetMapping("/properties/user/{userId}")
    public ResponseEntity<List<PropertyDTO>> getAllPropertiesForUser(@PathVariable Long userId){
        List<PropertyDTO> listDTO = propertyService.getAllPropertiesForUser(userId);
        return new ResponseEntity<List<PropertyDTO>>(listDTO, HttpStatus.OK);
    }

//    http://localhost:8080/api/v1/properties/{id}
    @PutMapping("/properties/{id}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long id){
         PropertyDTO dto = propertyService.updateProperty(propertyDTO, id);
         return new ResponseEntity<PropertyDTO>(dto, HttpStatus.OK);
    }

//    http://localhost:8080/api/v1/properties/update-price/{id}
    @PatchMapping("/properties/update-price/{id}")
    public ResponseEntity<PropertyDTO> updatePrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long id){
         PropertyDTO dto = propertyService.updatePrice(propertyDTO, id);
         return new ResponseEntity<PropertyDTO>(dto, HttpStatus.OK);
    }

//http://localhost:8080/api/v1/properties/delete/{id}
    @DeleteMapping("/properties/delete/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id){
        propertyService.deleteProperty(id);
        return new ResponseEntity<Void>((Void) null, HttpStatus.NO_CONTENT);
    }
}
