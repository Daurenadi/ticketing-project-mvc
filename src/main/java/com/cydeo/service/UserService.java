package com.cydeo.service;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;

import java.util.List;

public interface UserService {
    List<UserDTO> listAllUsers();
    void save(UserDTO user);
    UserDTO findById(String username);

    UserDTO findByUserName(String username);

    void update(UserDTO user);
    void delete(String username);
    List<UserDTO> ListAllByRole(String role);


}
