package com.holberton.domain.enumeration.companytype;

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
@RequestMapping("/api/company-types")
public class CompanyTypeController {
    @GetMapping
    public ResponseEntity<List<CompanyTypeDTO>> get() {
        List<CompanyTypeDTO> list = Arrays.stream(CompanyType.values())
                .map(CompanyTypeDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }
}
