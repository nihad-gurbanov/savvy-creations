package com.holberton.repository;

import com.holberton.domain.Project;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends BaseJpaRepository<Project, Long>{
}
