package com.holberton.controller;

import com.holberton.domain.Company;
import com.holberton.dto.CompanyDTO;
import com.holberton.service.GenericService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/company")
@CrossOrigin(origins = "*")
public class CompanyController extends GenericController<Company, CompanyDTO> {
    public CompanyController(GenericService<Company, CompanyDTO> genericService) {
        super(genericService);
    }
}
