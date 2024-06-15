package com.holberton.repository;

import com.holberton.domain.Company;
import com.holberton.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends BaseJpaRepository<Company, Long>{
    Optional<Company> findByUser(User user);
}
