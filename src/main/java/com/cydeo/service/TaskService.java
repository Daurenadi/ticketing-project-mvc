package com.cydeo.service;

import com.cydeo.dto.TaskDTO;
import com.cydeo.enums.Status;

import java.util.List;

public interface TaskService {

    void save(TaskDTO taskDTO);
    List<TaskDTO> findAll();
    List<TaskDTO> listAllTasks();
    void deleteById(Long id);
    TaskDTO findById(Long id);
    void update(TaskDTO taskDTO);
    List<TaskDTO> findAllPendingTasks(Status status);
    List<TaskDTO> findAllCompleteTasks(Status status);
    void updateTask(TaskDTO taskDTO);
}
