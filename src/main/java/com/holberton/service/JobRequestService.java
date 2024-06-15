package com.holberton.service;

import com.holberton.domain.JobRequest;
import com.holberton.domain.Project;
import com.holberton.domain.Talent;
import com.holberton.domain.enumeration.jobrequeststatus.JobRequestStatus;
import com.holberton.dto.JobRequestDTO;
import com.holberton.exception.CustomNotFoundException;
import com.holberton.repository.BaseJpaRepository;
import com.holberton.repository.JobRequestRepository;
import com.holberton.repository.ProjectRepository;
import com.holberton.repository.TalentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobRequestService extends GenericService<JobRequest, JobRequestDTO> {

    private final TalentRepository talentRepository;
    private final ProjectRepository projectRepository;
    private final JobRequestRepository jobRequestRepository;

    public JobRequestService(BaseJpaRepository<JobRequest, Long> repository, TalentRepository talentRepository, ProjectRepository projectRepository, JobRequestRepository jobRequestRepository) {
        super(repository);
        this.talentRepository = talentRepository;
        this.projectRepository = projectRepository;
        this.jobRequestRepository = jobRequestRepository;
    }

    @Override
    public JobRequestDTO add(JobRequestDTO dto) {
        Talent talent = talentRepository.findById(dto.getTalentId()).orElseThrow(
                () -> new CustomNotFoundException("Talent not found")
        );
        Project project = projectRepository.findById(dto.getProjectId()).orElseThrow(
                () -> new CustomNotFoundException("Project not found")
        );
        JobRequest jobRequest = new JobRequest();
        jobRequest.setJobRequestStatus(JobRequestStatus.WAITING);
        jobRequest = jobRequestRepository.save(jobRequest);
        return jobRequest.toDto();
    }

    public List<JobRequestDTO> findAllByProjectId(Long projectId) {
        List<JobRequest> jobRequests = jobRequestRepository.findAllByProjectId(projectId);
        return jobRequests.stream()
                .map(JobRequest::toDto)
                .collect(Collectors.toList());
    }

    public List<JobRequestDTO> findAllByTalentId(Long talentId) {
        List<JobRequest> jobRequests = jobRequestRepository.findAllByTalentId(talentId);
        return jobRequests.stream()
                .map(JobRequest::toDto)
                .collect(Collectors.toList());
    }
}
