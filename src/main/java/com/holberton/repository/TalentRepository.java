package com.holberton.repository;

import com.holberton.domain.Talent;
import com.holberton.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TalentRepository extends BaseJpaRepository<Talent, Long>{
    Optional<Talent> findByUser(User user);
}
