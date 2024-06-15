package com.holberton.service;

import com.holberton.domain.Company;
import com.holberton.domain.Project;
import com.holberton.domain.enumeration.projectstatus.ProjectStatus;
import com.holberton.dto.JobRequestDTO;
import com.holberton.dto.ProjectDTO;
import com.holberton.exception.CustomNotFoundException;
import com.holberton.repository.BaseJpaRepository;
import com.holberton.repository.CompanyRepository;
import com.holberton.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService extends GenericService<Project, ProjectDTO> {
    private final ProjectRepository projectRepository;
    private final CompanyRepository companyRepository;

    public ProjectService(BaseJpaRepository<Project, Long> repository, ProjectRepository projectRepository, CompanyRepository companyRepository) {
        super(repository);
        this.projectRepository = projectRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public ProjectDTO add(ProjectDTO dto) {
        Company company = companyRepository.findById(dto.getCompanyId()).orElseThrow(
                () -> new CustomNotFoundException("Company not found")
        );
        Project project = new Project();
        project.setCompany(company);
        project = dto.toEntity(Optional.of(project));
        projectRepository.save(project);
        return project.toDto();
    }

    public List<ProjectDTO> findProjectsByTalentId(Long talentId) {
        List<Project> projects = projectRepository.findProjectsByTalentId(talentId);
        return projects.stream()
                .map(Project::toDto)
                .collect(Collectors.toList());
    }

    public List<ProjectDTO> findProjectsByCompanyId(Long companyId) {
        List<Project> projects = projectRepository.findAllByCompanyId(companyId);
        return projects.stream()
                .map(Project::toDto)
                .collect(Collectors.toList());
    }

    public void addTalentToProject(JobRequestDTO jobRequestDTO) {
        projectRepository.addTalentToProject(jobRequestDTO.getTalentId(), jobRequestDTO.getProjectId());
        Project project = projectRepository.findById(jobRequestDTO.getProjectId()).orElseThrow(
                ()->new CustomNotFoundException("Project not found")
        );
        project.setStatus(ProjectStatus.ONGOING);
        projectRepository.save(project);
    }
}
