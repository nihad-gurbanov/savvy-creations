package com.holberton.domain;

import com.holberton.dto.TalentDTO;
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
@Table(name = "talents")
public class Talent extends BaseEntity<TalentDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "surname", length = 100)
    private String surname;

    @Column(updatable = false)
    private LocalDate createdAt;

    @Column(name = "phone_number", length = 50)
    private String phoneNumber;

    @Column(name = "location", length = 100)
    private String location;

    @Column(name = "about", length = 1000)
    private String about;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profession_id", nullable = false)
    private Profession profession;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "project_talents",
            joinColumns = {@JoinColumn(name = "talent_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id", referencedColumnName = "id")})
    private List<Project> projects;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDate.now();
    }

    @Override
    public TalentDTO toDto() {
        TalentDTO dto = new TalentDTO();
        dto.setId(this.id);
        dto.setUsername(this.user.getUsername());
        dto.setName(this.name);
        dto.setSurname(this.surname);
        dto.setPhoneNumber(this.phoneNumber);
        dto.setLocation(this.location);
        dto.setAbout(this.about);
        dto.setProfessionDTO(this.profession.toDto());
        return dto;
    }
}
