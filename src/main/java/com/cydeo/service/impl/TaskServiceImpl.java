package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.ProjectStatus;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service

public class TaskServiceImpl extends AbstractMapService<TaskDTO,Long> implements TaskService {
    @Override
    public TaskDTO save(TaskDTO task) {

        if(task.getAssignedDate() == null){
            task.setAssignedDate(LocalDate.now());
        }

        if(task.getTaskStatus() == null){
            task.setTaskStatus(ProjectStatus.OPEN);
        }
        if(task.getId() == null){
            task.setId(UUID.randomUUID().getMostSignificantBits());
        }
        return super.save(task.getId(),task);
    }

    @Override
    public TaskDTO findById(Long Id) {
        return super.findById(Id);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(TaskDTO task) {
        TaskDTO foundTask = findById(task.getId());
        task.setTaskStatus(foundTask.getTaskStatus());
        task.setAssignedDate(foundTask.getAssignedDate());
     super.update(task.getId(), task);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public List<TaskDTO> findTasksByManager(UserDTO manager) {
        return findAll().stream()
                .filter(task -> task.getProject().getUserDTO().equals(manager))
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> findAllPendingTasks(ProjectStatus status) {
        return findAll().stream()
                .filter(task->!task.getTaskStatus().equals(status))
                .collect(Collectors.toList());

    }

    @Override
    public List<TaskDTO> findAllCompleteTasks(ProjectStatus status) {
        return findAll().stream()
                .filter(task->task.getTaskStatus().equals(status))
                .collect(Collectors.toList());
    }

    @Override
    public void updateTask(TaskDTO task) {
        findById(task.getId()).setTaskStatus(task.getTaskStatus());
        update(task);
    }
}
