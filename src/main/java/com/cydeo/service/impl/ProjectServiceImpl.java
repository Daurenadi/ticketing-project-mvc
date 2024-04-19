package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.enums.ProjectStatus;
import com.cydeo.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements ProjectService {

    @Override
    public ProjectDTO save(ProjectDTO project) {
        if(project.getStatus() == null){
        project.setStatus(ProjectStatus.OPEN);}
        return super.save(project.getProjectCode(),project);
    }

    @Override
    public ProjectDTO findById(String username) {

        return super.findById(username);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(ProjectDTO object) {

        if(object.getStatus() == null){
            object.setStatus(findById(object.getProjectCode()).getStatus());
        }
        super.update(object.getProjectCode(), object);
    }

    @Override
    public void deleteById(String username) {
       super.deleteById(username);
    }

    @Override
    public void complete(ProjectDTO project) {
        project.setStatus(ProjectStatus.COMPLETE);
    }
}
