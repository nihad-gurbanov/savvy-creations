package com.holberton.service;

import com.holberton.domain.*;
import com.holberton.dto.TalentDTO;
import com.holberton.exception.CustomNotFoundException;
import com.holberton.repository.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class TalentService extends GenericService<Talent, TalentDTO> {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;
    private final TalentRepository talentRepository;
    private final ProfessionRepository professionRepository;

    public TalentService(BaseJpaRepository<Talent, Long> repository, UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository, TalentRepository talentRepository, ProfessionRepository professionRepository) {
        super(repository);
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
        this.talentRepository = talentRepository;
        this.professionRepository = professionRepository;
    }

    @Override
    public TalentDTO add(TalentDTO dto) {
        userRepository.findByUsername(dto.getUsername()).ifPresent(account -> {
            throw new IllegalArgumentException("This username is already taken");
        });
        Profession profession = professionRepository.findById(dto.getProfessionId()).orElseThrow(
                () -> new CustomNotFoundException("Profession not found")
        );
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        Authority authority = authorityRepository.findByAuthority(UserAuthority.TALENT.toString())
                .orElseGet(() -> {
                    Authority newAuthority = new Authority();
                    newAuthority.setAuthority(UserAuthority.TALENT.toString());
                    return authorityRepository.save(newAuthority);
                });
        user.setAuthorities(Set.of(authority));
        user = userRepository.save(user);
        Talent talent = new Talent();
        talent.setUser(user);
        talent.setProfession(profession);
        talent = dto.toEntity(Optional.of(talent));
        talentRepository.save(talent);
        return talent.toDto();
    }
}
