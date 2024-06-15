package com.holberton.controller;

import com.holberton.domain.Talent;
import com.holberton.dto.TalentDTO;
import com.holberton.service.GenericService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/talent")
@CrossOrigin(origins = "*")
public class TalentController extends GenericController<Talent, TalentDTO> {
    public TalentController(GenericService<Talent, TalentDTO> genericService) {
        super(genericService);
    }
}
