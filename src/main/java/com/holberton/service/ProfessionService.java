package com.holberton.service;

import com.holberton.domain.Profession;
import com.holberton.dto.ProfessionDTO;
import com.holberton.repository.BaseJpaRepository;
import com.holberton.repository.ProfessionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessionService extends GenericService<Profession, ProfessionDTO> {

    private final ProfessionRepository professionRepository;

    public ProfessionService(BaseJpaRepository<Profession, Long> repository, ProfessionRepository professionRepository) {
        super(repository);
        this.professionRepository = professionRepository;
    }

    @Override
    public ProfessionDTO add(ProfessionDTO dto) {
        Profession profession = new Profession();
        profession = dto.toEntity(Optional.of(profession));
        return professionRepository.save(profession).toDto();
    }
}
