package com.holberton.service;

import com.holberton.domain.Authority;
import com.holberton.domain.Company;
import com.holberton.domain.User;
import com.holberton.domain.UserAuthority;
import com.holberton.dto.CompanyDTO;
import com.holberton.repository.AuthorityRepository;
import com.holberton.repository.BaseJpaRepository;
import com.holberton.repository.CompanyRepository;
import com.holberton.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import java.util.Set;

@Service
public class CompanyService extends GenericService<Company, CompanyDTO> {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;

    private final CompanyRepository companyRepository;

    public CompanyService(BaseJpaRepository<Company, Long> repository, UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository, CompanyRepository companyRepository) {
        super(repository);
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public CompanyDTO add(CompanyDTO dto) {
        userRepository.findByUsername(dto.getUsername()).ifPresent(account -> {
            throw new IllegalArgumentException("This username is already taken");
        });
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        Authority authority = authorityRepository.findByAuthority(UserAuthority.COMPANY.toString())
                .orElseGet(() -> {
                    Authority newAuthority = new Authority();
                    newAuthority.setAuthority(UserAuthority.COMPANY.toString());
                    return authorityRepository.save(newAuthority);
                });
        user.setAuthorities(Set.of(authority));
        user = userRepository.save(user);
        Company company = new Company();
        company = dto.toEntity(Optional.of(company));
        company.setUser(user);
        company.setUserId(user.getId());
        companyRepository.save(company);
        return company.toDto();
    }
}
