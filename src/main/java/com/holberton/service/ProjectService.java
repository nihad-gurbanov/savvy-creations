package com.holberton.service;

import com.holberton.domain.Project;
import com.holberton.dto.ProjectDTO;
import com.holberton.repository.BaseJpaRepository;
import com.holberton.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService extends GenericService<Project, ProjectDTO> {
    private final ProjectRepository projectRepository;

    public ProjectService(BaseJpaRepository<Project, Long> repository, ProjectRepository projectRepository) {
        super(repository);
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectDTO add(ProjectDTO dto) {
        return null;
    }
}
