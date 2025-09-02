package com.upen.bean_validation_example.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotBlank(message = "User name cannot be null")
    private String userName;
    @Email(message = "Email should be valid")
    private String email;

    private char gender;
    @Min(18)
    @Max(65)
    private int age;

}
