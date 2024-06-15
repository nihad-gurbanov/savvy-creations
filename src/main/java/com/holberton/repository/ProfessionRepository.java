package com.holberton.repository;

import com.holberton.domain.Profession;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionRepository extends BaseJpaRepository<Profession, Long>{
}
