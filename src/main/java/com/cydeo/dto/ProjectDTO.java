package com.cydeo.dto;

import com.cydeo.enums.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor


public class ProjectDTO {

    private String projectName;
    private String projectCode;
    private UserDTO userDTO;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate assignedDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate projectEndDate;
    private String projectDetail;
    private ProjectStatus status;

}
