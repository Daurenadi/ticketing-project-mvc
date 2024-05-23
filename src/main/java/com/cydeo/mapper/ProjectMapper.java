package com.cydeo.mapper;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ProjectMapper {

   private final ModelMapper modelMapper;

    public ProjectMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProjectDTO convertToDTO(Project project){

       return modelMapper.map(project, ProjectDTO.class);
    }

    public Project convertToEntity(ProjectDTO project){

        return modelMapper.map(project, Project.class);
    }
}
