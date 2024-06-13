package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;

import java.util.List;

public interface ProjectService {

List<ProjectDTO> findAll();
ProjectDTO findByProjectCode(String code);

void save(ProjectDTO projectDTO);

void deleteById(String projectCode);
void complete(String projectCode);
void update(ProjectDTO projectDTO);
List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager);



}
