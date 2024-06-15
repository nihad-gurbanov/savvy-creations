package com.holberton.domain;

import com.holberton.domain.enumeration.projectcategory.ProjectCategory;
import com.holberton.domain.enumeration.projectservicetype.ProjectServiceType;
import com.holberton.domain.enumeration.projectstatus.ProjectStatus;
import com.holberton.dto.ProjectDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "projects")
public class Project extends BaseEntity<ProjectDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    @Enumerated(EnumType.STRING)
    private ProjectCategory projectCategory;

    @Enumerated(EnumType.STRING)
    private ProjectServiceType projectServiceType;

    @Column(updatable = false)
    private LocalDate createdAt;

    @Column(name = "requirements", length = 1000)
    private String requirements;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToMany(mappedBy = "projects")
    private List<Talent> talents;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<JobRequest> jobRequests;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDate.now();
    }

    @Override
    public ProjectDTO toDto() {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setRequirements(this.requirements);
        dto.setProjectCategoryId(this.projectCategory.getId());
        dto.setProjectServiceTypeId(this.projectServiceType.getId());
        dto.setCompanyId(this.company.getId());
        dto.setCompanyDTO(this.company.toDto());
        return dto;
    }
}
