package com.holberton.domain.enumeration.projectcategory;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum ProjectCategory {
    ECOMMERCE(1),
    EDUCATION(2),
    ERP(3),
    FINTECH(4),
    CUSTOMER_RELATIONSHIP_MANAGEMENT(5),
    HUMAN_RESOURCES(6),
    PROJECT_MANAGEMENT(7),
    CONTENT_MANAGEMENT_SYSTEM(8),
    HEALTHCARE(9),
    BUSINESS_INTELLIGENT(10),
    ACCOUNTING(11),
    SUPPLY_CHAIN_MANAGEMENT(12),
    CYBER_SECURITY(13),
    COLLABORATION(14),
    GRAPHIC_DESIGN(15),
    CLOUD_COMPUTING(16),
    DEVOPS_TOOLS(17),
    MARKETING_AUTOMATION(18),
    OTHER(19);
    private final Integer id;

    ProjectCategory(Integer id) {
        this.id = id;
    }

    public static ProjectCategory of(Integer id) {
        return Arrays.stream(ProjectCategory.values())
                .filter(status -> Objects.equals(status.getId(), id))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Project category not found: " + id)
                );
    }
}
