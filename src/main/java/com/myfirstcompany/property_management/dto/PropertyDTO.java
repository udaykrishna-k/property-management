package com.myfirstcompany.property_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {
    private Long id;
    private String title;
    private String address;
    private Double price;
    private Long userId;
}
