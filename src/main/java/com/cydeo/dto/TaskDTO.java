package com.cydeo.dto;


import com.cydeo.enums.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private Long Id;
    private ProjectDTO project;
    private UserDTO user;
    private String taskSubject;
    private String taskDetails;
    private ProjectStatus taskStatus;
    private LocalDate assignedDate;



}
