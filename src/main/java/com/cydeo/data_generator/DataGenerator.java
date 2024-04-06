package com.cydeo.data_generator;

import com.cydeo.dto.RoleDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.impl.RoleServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DataGenerator implements CommandLineRunner {
    private final RoleService roleService;

    public DataGenerator(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {

        RoleDTO adminRole = new RoleDTO(1L, "Admin");
        RoleDTO managerRole = new RoleDTO(2L, "Manager");
        RoleDTO employeeRole = new RoleDTO(3L, "Employee");


        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

    }
}
