package com.holberton.repository;

import com.holberton.domain.Authority;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface AuthorityRepository extends BaseJpaRepository<Authority, Long> {
    Optional<Authority> findByAuthority(String authority);
}
