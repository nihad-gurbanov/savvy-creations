package com.holberton.domain;

import com.holberton.domain.enumeration.jobrequeststatus.JobRequestStatus;
import com.holberton.dto.JobRequestDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "job_requests")
public class JobRequest extends BaseEntity<JobRequestDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "talent_id", nullable = false)
    private Talent talent;

    @Enumerated(EnumType.STRING)
    private JobRequestStatus jobRequestStatus;

    @Override
    public JobRequestDTO toDto() {
        JobRequestDTO dto = new JobRequestDTO();
        dto.setId(this.id);
        dto.setProjectId(this.project.getId());
        dto.setProjectDTO(this.project.toDto());
        dto.setTalentDTO(this.talent.toDto());
        dto.setTalentId(this.talent.getId());
        dto.setJobRequestStatus(this.jobRequestStatus);
        return dto;
    }
}
