package com.cydeo.entity;


import com.cydeo.enums.ProjectStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "projects")
@Where(clause = "is_deleted=false")
public class Project extends BaseEntity {

    private String projectName;
    @Column(unique = true)
    private String projectCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private User assignedManager;
    @Column(columnDefinition = "DATE")
    private LocalDate startDate;
    @Column(columnDefinition = "DATE")
    private LocalDate endDate;
    private String projectDetail;
    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;
   // @NotNull
   // private int completeTaskCounts;
   // private int unfinishedTaskCounts;
}
