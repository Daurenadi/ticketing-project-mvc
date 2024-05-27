package com.cydeo.repository;

import com.cydeo.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cydeo.entity.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {


    List<Task> findAllByTaskStatusIsNot(Status status);
    List<Task> findAllByTaskStatusIs(Status status);


}
