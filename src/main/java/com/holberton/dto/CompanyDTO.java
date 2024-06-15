package com.holberton.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.holberton.domain.Company;
import com.holberton.domain.enumeration.companytype.CompanyType;
import lombok.*;

import java.util.Optional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO extends BaseDTO<Company> {
    private Long id;

    @NotEmpty
    @Size(max = 100)
    private String username;

    @Size(max = 100)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotEmpty
    @Size(max = 100)
    private String name;

    @NotEmpty
    @Size(max = 100)
    private String surname;

    @Size(max = 50)
    private String phoneNumber;

    @Size(max = 100)
    private String location;

    private Integer companyTypeId;

    @Size(max = 1000)
    private String about;

    @Size(max = 100)
    @NotEmpty
    private String companyName;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate createdAt;

    public Company toEntity(Optional<Company> existingEntity) {
        Company entity = existingEntity.orElseGet(Company::new);
        entity.setName(this.name);
        entity.setSurname(this.surname);
        entity.setPhoneNumber(this.phoneNumber);
        entity.setLocation(this.location);
        entity.setCompanyType(companyTypeId != null ? CompanyType.of(this.companyTypeId) : null);
        entity.setAbout(this.about);
        entity.setCompanyName(this.companyName);
        return entity;
    }
}
