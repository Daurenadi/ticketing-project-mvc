package com.cydeo.dto;

import com.cydeo.enums.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProjectDTO {
    @NotBlank
    private String projectName;
    @NotBlank
    private String projectCode;
    @NotNull
    private UserDTO userDTO;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate assignedDate;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate projectEndDate;
    @NotBlank
    private String projectDetail;
    private ProjectStatus status;
    private int completeTaskCounts;
    private int unfinishedTaskCounts;


}
