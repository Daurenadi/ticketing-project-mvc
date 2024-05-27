package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.enums.Status;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.ProjectRepository;
import com.cydeo.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final MapperUtil mapperUtil;
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(MapperUtil mapperUtil, ProjectRepository projectRepository) {
        this.mapperUtil = mapperUtil;
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectDTO> findAll() {
        List<Project> projectEntities = projectRepository.findAll();
        return projectEntities.stream()
                .map(project -> mapperUtil.convert(project, ProjectDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public ProjectDTO findByProjectCode(String code) {
        Project project = projectRepository.findByProjectCode(code);
        return mapperUtil.convert(project, ProjectDTO.class);
    }

    @Override
    public void save(ProjectDTO projectDTO) {
        projectDTO.setStatus(Status.OPEN);
       Project project = mapperUtil.convert(projectDTO,Project.class);
       projectRepository.save(project);
    }

    @Override
    public void deleteById(String projectCode) {
        Project project = projectRepository.findByProjectCode(projectCode);
        project.setIsDeleted(true);
        projectRepository.save(project);
    }

    @Override
    public void complete(String projectCode) {
        Project project = projectRepository.findByProjectCode(projectCode);
        project.setProjectStatus(Status.COMPLETE);
        projectRepository.save(project);
    }

    @Override
    public void update(ProjectDTO projectDTO) {
        Project project = projectRepository.findByProjectCode(projectDTO.getProjectCode());
        Project convertedProject = mapperUtil.convert(projectDTO, Project.class);
        convertedProject.setId(project.getId());
        convertedProject.setProjectStatus(project.getProjectStatus());
        projectRepository.save(convertedProject);
    }
}
