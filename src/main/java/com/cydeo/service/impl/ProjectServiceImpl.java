package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.enums.ProjectStatus;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import com.cydeo.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectMapper projectMapper;
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectMapper projectMapper, ProjectRepository projectRepository) {
        this.projectMapper = projectMapper;
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectDTO> findAll() {
        List<Project> projectEntities = projectRepository.findAll();
        return projectEntities.stream()
                .map(projectMapper::convertToDTO)
                .collect(Collectors.toList());

    }

    @Override
    public ProjectDTO findByProjectCode(String code) {
        Project project = projectRepository.findByProjectCode(code);
        return projectMapper.convertToDTO(project);
    }

    @Override
    @Transactional
    public void save(ProjectDTO projectDTO) {
        projectDTO.setStatus(ProjectStatus.OPEN);
       Project project = projectMapper.convertToEntity(projectDTO);
       projectRepository.save(project);
    }
}
