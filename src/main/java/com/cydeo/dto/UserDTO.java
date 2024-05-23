package com.cydeo.dto;

import com.cydeo.enums.Gender;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Setter
public class UserDTO {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
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
    @NotNull
    private RoleDTO role;
    @NotNull
    private Gender gender;
}
