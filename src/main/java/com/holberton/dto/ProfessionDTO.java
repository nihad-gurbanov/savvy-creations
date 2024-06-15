package com.holberton.dto;

import com.holberton.domain.Company;
import com.holberton.domain.Profession;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Optional;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionDTO extends BaseDTO<Profession> {
    private Long id;

    @NotEmpty
    @Size(max = 100)
    private String name;

    @Override
    public Profession toEntity(Optional<Profession> existingEntity) {
        Profession entity = existingEntity.orElseGet(Profession::new);
        entity.setName(this.name);
        return entity;
    }
}
