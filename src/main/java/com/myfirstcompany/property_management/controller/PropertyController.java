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
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

//    http://localhost:8080/api/v1/properties
    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
        List<PropertyDTO> listDTO = propertyService.getAllProperties();
        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(listDTO, HttpStatus.OK);
        return responseEntity;
    }
//    http://localhost:8080/api/v1/properties/{id}
    @PutMapping("/properties/{id}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long id){
         PropertyDTO dto = propertyService.updateProperty(propertyDTO, id);
         ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(dto, HttpStatus.OK);
         return responseEntity;
    }

//    http://localhost:8080/api/v1/properties/update-price/{id}
    @PatchMapping("/properties/update-price/{id}")
    public ResponseEntity<PropertyDTO> updatePrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long id){
         PropertyDTO dto = propertyService.updatePrice(propertyDTO, id);
         ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(dto, HttpStatus.OK);
         return responseEntity;
    }

//http://localhost:8080/api/v1/properties/delete/{id}
    @DeleteMapping("/properties/delete/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id){
        propertyService.deleteProperty(id);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return responseEntity;
    }
}
