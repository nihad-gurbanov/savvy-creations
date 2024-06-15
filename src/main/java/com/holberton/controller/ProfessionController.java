package com.holberton.controller;

import com.holberton.domain.Profession;
import com.holberton.dto.ProfessionDTO;
import com.holberton.service.GenericService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/profession")
@CrossOrigin(origins = "*")
public class ProfessionController extends GenericController<Profession, ProfessionDTO> {
    public ProfessionController(GenericService<Profession, ProfessionDTO> genericService) {
        super(genericService);
    }
}
