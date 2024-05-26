package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.UserRepository;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final MapperUtil mapperUtil;

    public UserServiceImpl(UserRepository userRepository, MapperUtil mapperUtil) {
        this.userRepository = userRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<UserDTO> listAllUsers() {
       List<User> list = userRepository.findAll();
       return list.stream()
               .map(user -> mapperUtil.convert(user, UserDTO.class))
               .collect(Collectors.toList());

    }

    @Override
    public void save(UserDTO user) {
        userRepository.save(mapperUtil.convert(user, User.class));
    }

    @Override
    public UserDTO findById(String username) {
        User user = userRepository.findByUserName(username);

        return mapperUtil.convert(user, UserDTO.class);
    }

    @Override
    public UserDTO findByUserName(String username) {
        User user = userRepository.findByUserName(username);
        return mapperUtil.convert(user, UserDTO.class);
    }

    @Override
    public void update(UserDTO user) {
        User userEntity = userRepository.findByUserName(user.getUserName());
        User convertedUser = mapperUtil.convert(user, User.class);
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
    @Transactional
    public List<UserDTO> ListAllByRole(String role) {
        List<User> list = userRepository.findByRoleDescriptionIgnoreCase(role);
        return list.stream().map(user -> mapperUtil.convert(user, UserDTO.class))
                .collect(Collectors.toList());
    }
}
