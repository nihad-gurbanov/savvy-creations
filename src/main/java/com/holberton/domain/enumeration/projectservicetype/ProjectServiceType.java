package com.holberton.domain.enumeration.projectservicetype;

import com.holberton.domain.enumeration.projectcategory.ProjectCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum ProjectServiceType {
    FULL_STACK_WEB_DEVELOPMENT(1),
    FRONT_END_DEVELOPMENT(2),
    BACK_END_DEVELOPMENT(3),
    IOS_DEVELOPMENT(4),
    ANDROID_DEVELOPMENT(5),
    CROSS_MOBILE_DEVELOPMENT(6),
    DESKTOP_DEVELOPMENT(7),
    UI_UX_DESIGN(8),
    DATA_SCIENCE_MACHINE_LEARNING(9);
    private final Integer id;

    ProjectServiceType(Integer id) {
        this.id = id;
    }

    public static ProjectServiceType of(Integer id) {
        return Arrays.stream(ProjectServiceType.values())
                .filter(status -> Objects.equals(status.getId(), id))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Project service type not found: " + id)
                );
    }
}
