package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Role;
import com.cydeo.entity.User;
import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import com.cydeo.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> listAllUsers() {
       List<User> list = userRepository.findAll();
       return list.stream().map(userMapper::convertToDTO).collect(Collectors.toList());

    }

    @Override
    public void save(UserDTO user) {
        userRepository.save(userMapper.convertToEntity(user));
    }

    @Override
    public UserDTO findById(String username) {
        User user = userRepository.findByUserName(username);

        return userMapper.convertToDTO(user);
    }

    @Override
    public void update(UserDTO user) {
        User userEntity = userRepository.findByUserName(user.getUserName());
        User convertedUser = userMapper.convertToEntity(user);
        convertedUser.setId(userEntity.getId());
        userRepository.save(convertedUser);
    }

    @Override
    @Transactional
    public void delete(String username) {

       User userEntity = userRepository.findByUserName(username);
       userEntity.setIsDeleted(true);
       userRepository.save(userEntity);
    }

    @Override
    public List<UserDTO> findManagers(String role) {
        List<User> managersEntities = userRepository.findByRoleDescriptionIgnoreCase(role);
       return managersEntities.stream()
                .map(userMapper::convertToDTO)
                .collect(Collectors.toList());
    }
}
