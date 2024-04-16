package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.service.RoleService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl extends AbstractMapService<RoleDTO, Long> implements RoleService {

    @Override
    public RoleDTO save(RoleDTO role) {
        return super.save(role.getId(), role);
    }

    @Override
    public RoleDTO findById(Long username) {
        return super.findById(username);
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long username) {
     super.deleteById(username);
    }

    @Override
    public void update(RoleDTO object) {
        super.update(object.getId(), object);
    }
}
