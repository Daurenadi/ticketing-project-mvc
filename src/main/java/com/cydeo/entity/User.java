package com.cydeo.entity;

import com.cydeo.dto.RoleDTO;
import com.cydeo.enums.Gender;
import com.cydeo.model.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.util.EnumSet;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity{


    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean enabled;
    private String phone;
    private Role role;
    private Gender gender;





}
