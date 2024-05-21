package com.cydeo.entity;


import com.cydeo.enums.ProjectStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "projects")
@Where(clause = "is_deleted=false")
public class Project extends BaseEntity {

    private String projectName;
    private String projectCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private User user;
    @Column(columnDefinition = "DATE")
    private LocalDate assignedDate;
    @Column(columnDefinition = "DATE")
    private LocalDate projectEndDate;
    private String projectDetail;
    @Enumerated(EnumType.STRING)
    private ProjectStatus status;
    private int completeTaskCounts;
    private int unfinishedTaskCounts;
}
