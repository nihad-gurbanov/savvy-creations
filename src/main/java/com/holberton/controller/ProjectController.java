package com.holberton.controller;

import com.holberton.auth.UserDetailsService;
import com.holberton.domain.Project;
import com.holberton.domain.Talent;
import com.holberton.domain.enumeration.projectstatus.ProjectStatus;
import com.holberton.dto.ProjectDTO;
import com.holberton.service.GenericService;
import com.holberton.service.ProjectService;
import com.holberton.service.TalentService;
import com.holberton.domain.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
@CrossOrigin(origins = "*")
public class ProjectController extends GenericController<Project, ProjectDTO> {

    private final UserDetailsService userDetailsService;
    private final TalentService talentService;
    private final ProjectService projectService;

    public ProjectController(GenericService<Project, ProjectDTO> genericService, UserDetailsService userDetailsService, TalentService talentService, ProjectService projectService) {
        super(genericService);
        this.userDetailsService = userDetailsService;
        this.talentService = talentService;
        this.projectService = projectService;
    }

    @PostMapping("/complete/{project-id}")
    @PreAuthorize("TALENT")
    public ProjectDTO completeProject(Principal principal, @PathVariable("project-id") Long id) {
        User user = (User) userDetailsService.loadUserByUsername(principal.getName());
        Talent talent = talentService.findByUser(user);
        for (Project project : talent.getProjects()) {
            if (project.getId() == id) {
                project.setStatus(ProjectStatus.COMPLETED);
                return projectService.update(id, project.toDto());
            }
        }
        throw new IllegalArgumentException("Project not found");
    }

    @GetMapping("by-talent/{talent-id}")
    public List<ProjectDTO> getProjectsByTalent(@PathVariable("talent-id") Long id) {
        return projectService.findProjectsByTalentId(id);
    }

    @GetMapping("by-company/{company-id}")
    public List<ProjectDTO> getProjectsByCompany(@PathVariable("company-id") Long id) {
        return projectService.findProjectsByCompanyId(id);
    }
}
