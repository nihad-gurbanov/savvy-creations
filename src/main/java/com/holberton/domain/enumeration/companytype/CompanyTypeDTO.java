package com.holberton.domain.enumeration.companytype;

import lombok.Data;

@Data
public class CompanyTypeDTO {
    private final Integer id;
    private final String name;

    public CompanyTypeDTO(CompanyType companyType) {
        this.id = companyType.getId();
        this.name = companyType.name();
    }
}
