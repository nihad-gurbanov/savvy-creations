package com.holberton.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.holberton.domain.Talent;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Optional;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TalentDTO extends BaseDTO<Talent> {
    private Long id;

    @NotEmpty
    @Size(max = 100)
    private String username;

    @Size(max = 100)
    @NotEmpty
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

    @Size(max = 1000)
    private String about;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long professionId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private ProfessionDTO professionDTO;

    @Override
    public Talent toEntity(Optional<Talent> existingEntity) {
        Talent entity = existingEntity.orElseGet(Talent::new);
        entity.setName(this.name);
        entity.setSurname(this.surname);
        entity.setPhoneNumber(this.phoneNumber);
        entity.setLocation(this.location);
        entity.setAbout(this.about);
        return entity;
    }
}
