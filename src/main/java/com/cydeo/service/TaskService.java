package com.cydeo.service;

import com.cydeo.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    void save(TaskDTO taskDTO);
    List<TaskDTO> findAll();
    List<TaskDTO> listAllTasks();
    void deleteById(Long id);
    TaskDTO findById(Long id);
    void update(TaskDTO taskDTO);
}
