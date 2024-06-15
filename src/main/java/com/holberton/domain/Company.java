package com.holberton.domain;

import com.holberton.domain.enumeration.companytype.CompanyType;
import com.holberton.dto.CompanyDTO;
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
@Table(name = "companies")
public class Company extends BaseEntity<CompanyDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "surname", length = 100)
    private String surname;

    @Column(name = "phone_number", length = 50)
    private String phoneNumber;

    @Column(name = "location", length = 100)
    private String location;

    @Enumerated(EnumType.STRING)
    private CompanyType companyType;

    @Column(name = "about", length = 1000)
    private String about;

    @Column(name = "company_name", length = 100)
    private String companyName;

    @Column(updatable = false)
    private LocalDate createdAt;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Project> projects;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDate.now();
    }

    @Override
    public CompanyDTO toDto() {
        CompanyDTO dto = new CompanyDTO();
        dto.setId(this.id);
        dto.setUsername(this.user.getUsername());
        dto.setName(this.name);
        dto.setSurname(this.surname);
        dto.setPhoneNumber(this.phoneNumber);
        dto.setLocation(this.location);
        dto.setCompanyTypeId(companyType != null ? this.companyType.getId() : null);
        dto.setAbout(this.about);
        dto.setCompanyName(this.companyName);
        dto.setCreatedAt(this.createdAt);
        return dto;
    }
}
