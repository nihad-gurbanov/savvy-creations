package com.holberton.controller;

import com.holberton.domain.JobRequest;
import com.holberton.domain.enumeration.jobrequeststatus.JobRequestStatus;
import com.holberton.dto.JobRequestDTO;
import com.holberton.service.GenericService;
import com.holberton.service.JobRequestService;
import com.holberton.service.ProjectService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/job-request")
@CrossOrigin(origins = "*")
public class JobRequestController extends GenericController<JobRequest, JobRequestDTO> {
    private final JobRequestService jobRequestService;
    private final ProjectService projectService;

    public JobRequestController(GenericService<JobRequest, JobRequestDTO> genericService, JobRequestService jobRequestService, ProjectService projectService) {
        super(genericService);
        this.jobRequestService = jobRequestService;
        this.projectService = projectService;
    }

    @PreAuthorize("TALENT")
    @PostMapping("accept/{job-request-id}")
    public JobRequestDTO acceptJobRequest(@PathVariable("job-request-id") Long id) {
        JobRequestDTO jobRequestDTO = jobRequestService.findById(id);
        jobRequestDTO.setJobRequestStatus(JobRequestStatus.ACCEPTED);
        jobRequestService.update(jobRequestDTO.getId(), jobRequestDTO);
        projectService.addTalentToProject(jobRequestDTO);
        return jobRequestDTO;
    }

    @PreAuthorize("TALENT")
    @PostMapping("reject/{job-request-id}")
    public JobRequestDTO rejectJobRequest(@PathVariable("job-request-id") Long id) {
        JobRequestDTO jobRequestDTO = jobRequestService.findById(id);
        jobRequestDTO.setJobRequestStatus(JobRequestStatus.REJECTED);
        jobRequestService.update(jobRequestDTO.getId(), jobRequestDTO);
        return jobRequestDTO;
    }

    @GetMapping("by-talent/{talent-id}")
    public List<JobRequestDTO> getJobRequestsByTalentId(@PathVariable("talent-id") Long id) {
        return jobRequestService.findAllByTalentId(id);
    }

    @GetMapping("by-project/{project-id}")
    public List<JobRequestDTO> getJobRequestsByProjectId(@PathVariable("project-id") Long id) {
        return jobRequestService.findAllByProjectId(id);
    }
}
