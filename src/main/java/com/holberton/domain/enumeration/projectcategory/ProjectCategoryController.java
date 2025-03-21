package com.holberton.domain.enumeration.projectcategory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/project-categories")
public class ProjectCategoryController {
    @GetMapping
    public ResponseEntity<List<ProjectCategoryDTO>> get() {
        List<ProjectCategoryDTO> list = Arrays.stream(ProjectCategory.values())
                .map(ProjectCategoryDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }
}
