package com.holberton.domain;

import com.holberton.dto.ProfessionDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "professions")
public class Profession extends BaseEntity<ProfessionDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

    @OneToMany(mappedBy = "profession", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Talent> talents;

    @Override
    public ProfessionDTO toDto() {
        ProfessionDTO professionDTO = new ProfessionDTO();
        professionDTO.setId(this.id);
        professionDTO.setName(this.name);
        return professionDTO;
    }
}
