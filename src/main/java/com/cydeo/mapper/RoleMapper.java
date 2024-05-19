package com.cydeo.mapper;

import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RoleMapper{

   private final ModelMapper modelMapper;

    public RoleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RoleDTO convertToDTO(Role role){
        return modelMapper.map(role, RoleDTO.class);
    }

    public Role convertToEntity(RoleDTO roleDto){
        return modelMapper.map(roleDto, Role.class);
    }
}
