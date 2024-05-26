package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.RoleRepository;
import com.cydeo.service.RoleService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final MapperUtil mapperUtil;

    public RoleServiceImpl(RoleRepository roleRepository, MapperUtil mapperUtil) {
        this.roleRepository = roleRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<RoleDTO> listAllRoles() {
        List<Role> list = roleRepository.findAll();
        return list.stream()
                .map(role -> mapperUtil.convert(role, RoleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(Long Id) {
        Role role = roleRepository.findById(Id)
                .orElseThrow(() -> new IllegalArgumentException("Role not found for id: " + Id));
        return mapperUtil.convert(role, RoleDTO.class);
    }


}
