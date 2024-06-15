package com.holberton.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.holberton.domain.Company;
import com.holberton.domain.Project;
import com.holberton.domain.Talent;
import com.holberton.domain.enumeration.projectcategory.ProjectCategory;
import com.holberton.domain.enumeration.projectservicetype.ProjectServiceType;
import com.holberton.domain.enumeration.projectstatus.ProjectStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO extends BaseDTO<Project> {
    private Long id;

    @NotEmpty
    @Size(max = 200)
    private String name;

    @Enumerated(EnumType.STRING)
    private Integer projectCategoryId;

    @Enumerated(EnumType.STRING)
    private Integer projectServiceTypeId;

    @NotEmpty
    @Size(max = 1000)
    private String requirements;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long companyId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private CompanyDTO companyDTO;

    @Override
    public Project toEntity(Optional<Project> existingEntity) {
        Project entity = existingEntity.orElseGet(Project::new);
        entity.setName(this.name);
        entity.setStatus(ProjectStatus.NOT_ASSIGNED);
        entity.setProjectCategory(ProjectCategory.of(this.projectCategoryId));
        entity.setProjectServiceType(ProjectServiceType.of(this.projectServiceTypeId));
        entity.setRequirements(this.requirements);
        return null;
    }
}
