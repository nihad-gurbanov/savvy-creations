package com.holberton.controller;

import com.holberton.domain.Project;
import com.holberton.dto.ProjectDTO;
import com.holberton.service.GenericService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/project")
@CrossOrigin(origins = "*")
public class ProjectController extends GenericController<Project, ProjectDTO> {
    public ProjectController(GenericService<Project, ProjectDTO> genericService) {
        super(genericService);
    }
}
