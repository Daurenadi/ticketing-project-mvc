package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.ProjectStatus;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements ProjectService {

    private final TaskService taskService;

    public ProjectServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }
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

    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager){

        return
                findAll()
                        .stream()
                        .filter(project -> project.getUserDTO().equals(manager))  //John
                        .peek(project ->{

                            List<TaskDTO> taskList = taskService.findTasksByManager(manager);

                            int completeTaskCounts = (int) taskList.stream().filter(t -> t.getProject().equals(project) && t.getTaskStatus() == ProjectStatus.COMPLETE).count();
                            int unfinishedTaskCounts = (int) taskList.stream().filter(t -> t.getProject().equals(project) && t.getTaskStatus() != ProjectStatus.COMPLETE).count();

                            project.setCompleteTaskCounts(completeTaskCounts);
                            project.setUnfinishedTaskCounts(unfinishedTaskCounts);

                        })
                        .collect(Collectors.toList());



    }



}

