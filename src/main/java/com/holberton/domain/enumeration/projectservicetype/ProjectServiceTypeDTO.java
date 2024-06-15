package com.holberton.domain.enumeration.projectservicetype;

import lombok.Data;

@Data
public class ProjectServiceTypeDTO {
    private final Integer id;
    private final String name;

    public ProjectServiceTypeDTO(ProjectServiceType projectServiceType) {
        this.id = projectServiceType.getId();
        this.name = projectServiceType.name();
    }
}
