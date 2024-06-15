package com.holberton.domain.enumeration.projectcategory;

import lombok.Data;

@Data
public class ProjectCategoryDTO {
    private final Integer id;
    private final String name;

    public ProjectCategoryDTO(ProjectCategory projectCategory) {
        this.id = projectCategory.getId();
        this.name = projectCategory.name();
    }
}
