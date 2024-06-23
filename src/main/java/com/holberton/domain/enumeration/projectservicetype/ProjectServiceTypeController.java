package com.holberton.domain.enumeration.projectservicetype;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class ProjectServiceTypeController {
    @GetMapping("/api/project-service-types")
    public ResponseEntity<List<ProjectServiceTypeDTO>> get() {
        List<ProjectServiceTypeDTO> list = Arrays.stream(ProjectServiceType.values())
                .map(ProjectServiceTypeDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }
}
