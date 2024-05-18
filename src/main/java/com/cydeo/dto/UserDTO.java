package com.cydeo.dto;

import com.cydeo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {

    @NotBlank
    @Size(max = 15, min = 2)
    private String firstName;
    @NotBlank
    @Size(max = 15, min = 2)
    private String lastName;
    @NotBlank
    @Email
    private String userName;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email format")
    private String password;

    private boolean enabled;
    @NotBlank
    @Pattern(regexp = "^\\+?\\d{0,2}-?\\d{3}-?\\d{3}-?\\d{4}$", message = "Invalid phone number format")
    private String phone;

    private RoleDTO role;
    @NotNull
    private Gender gender;
}
