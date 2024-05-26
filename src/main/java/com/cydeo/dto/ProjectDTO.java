package com.cydeo.dto;

import com.cydeo.enums.ProjectStatus;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;



@NoArgsConstructor
@Getter
@Setter


public class ProjectDTO {

    private Long id;

    @NotBlank
    private String projectName;
    @NotBlank
    private String projectCode;
    @NotNull
    private UserDTO assignedManager;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @NotBlank
    private String projectDetail;
    private ProjectStatus projectStatus;
    private int completeTaskCounts;
    private int unfinishedTaskCounts;


}
