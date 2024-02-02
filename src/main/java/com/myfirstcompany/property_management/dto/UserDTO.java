package com.myfirstcompany.property_management.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long id;
    private String ownerName;
    @NotNull(message = "owner email cannot be null")
    @Size(min = 1, max = 50, message = "owner email cannot have more than 50 characters")
    @NotEmpty(message = "owner email field cannot be empty")
    private String ownerEmail;
    @NotNull(message = "password cannot be null")
    @Size(min = 1, max = 50, message = "password cannot have more than 50 characters")
    @NotEmpty(message = "password field cannot be empty")
    private String password;
    private String phone;
}
