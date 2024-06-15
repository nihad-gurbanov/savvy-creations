package com.holberton.repository;

import com.holberton.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface UserRepository extends BaseJpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
