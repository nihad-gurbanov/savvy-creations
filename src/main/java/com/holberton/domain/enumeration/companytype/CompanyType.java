package com.holberton.domain.enumeration.companytype;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum CompanyType {

    EDUCATION(1),
    HEALTHCARE(2),
    TECHNOLOGY(3),
    FINANCIAL_SERVICES(4),
    MANUFACTURING(5),
    RETAIL(6),
    HOSPITALITY(7),
    CONSTRUCTION(8);
    private final Integer id;

    CompanyType(Integer id) {
        this.id = id;
    }

    public static CompanyType of(Integer id) {
        return Arrays.stream(CompanyType.values())
                .filter(status -> Objects.equals(status.getId(), id))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Company type not found: " + id)
                );
    }
}
