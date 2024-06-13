package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.enums.Status;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.ProjectRepository;
import com.cydeo.repository.TaskRepository;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;
import com.cydeo.entity.Task;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final MapperUtil mapperUtil;

    private final ProjectRepository projectRepository;

    public TaskServiceImpl(TaskRepository taskRepository, MapperUtil mapperUtil, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.mapperUtil = mapperUtil;
        this.projectRepository = projectRepository;
    }

    @Override
    public void save(TaskDTO taskDTO) {
        taskDTO.setTaskStatus(Status.OPEN);
        taskDTO.setAssignedDate(LocalDate.now());
        Task task = mapperUtil.convert(taskDTO, Task.class);
        taskRepository.save(task);

    }

    @Override
    public List<TaskDTO> findAll() {
        List<Task> list = taskRepository.findAll();
        return list.stream()
                .map(task -> mapperUtil.convert(task, TaskDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> listAllTasks() {
        List<Task> list = taskRepository.findAll();
       return list.stream()
                .map(task -> mapperUtil.convert(task, TaskDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()){
            task.get().setIsDeleted(true);
            taskRepository.save(task.get());
        }
    }

    @Override
    public TaskDTO findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()){
          return  mapperUtil.convert(task.get(),TaskDTO.class);
        }
        return null;
    }

    @Override
    public void update(TaskDTO taskDTO) {
        Optional<Task> task = taskRepository.findById(taskDTO.getId());
        Task convertedTask = mapperUtil.convert(taskDTO, Task.class);
        if(task.isPresent()){
            convertedTask.setTaskStatus(taskDTO.getTaskStatus() == null ? task.get().getTaskStatus() : taskDTO.getTaskStatus());
            convertedTask.setAssignedDate(task.get().getAssignedDate());
            taskRepository.save(convertedTask);

        }

    }


    @Override
    public List<TaskDTO> findAllPendingTasks(Status status) {
        List<Task> list = taskRepository.findAllByTaskStatusIsNot(status);
        return list.stream()
                .map(task -> mapperUtil.convert(task, TaskDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> findAllCompleteTasks(Status status) {
        List<Task> list = taskRepository.findAllByTaskStatusIs(status);
        return list.stream()
                .map(task -> mapperUtil.convert(task, TaskDTO.class))
                .collect(Collectors.toList());
    }

   @Override
   public void updateTask(TaskDTO taskDTO) {
         Optional<Task> task = taskRepository.findById(taskDTO.getId());
         Task convertedtask = mapperUtil.convert(taskDTO, Task.class);
         if(task.isPresent()) {
             convertedtask.setId(task.get().getId());
             convertedtask.setAssignedDate(task.get().getAssignedDate());
             taskRepository.save(convertedtask);
         }else{throw new RuntimeException("Task not found");}




    }
}
