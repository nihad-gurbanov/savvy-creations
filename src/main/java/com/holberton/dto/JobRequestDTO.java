package com.holberton.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.holberton.domain.JobRequest;
import com.holberton.domain.Profession;
import com.holberton.domain.enumeration.jobrequeststatus.JobRequestStatus;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobRequestDTO extends BaseDTO<JobRequest> {
    private Long id;

    @NotNull
    private Long projectId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private ProjectDTO projectDTO;

    @NotNull
    private Long talentId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private TalentDTO talentDTO;

    private JobRequestStatus jobRequestStatus;

    @Override
    public JobRequest toEntity(Optional<JobRequest> existingEntity) {
        JobRequest entity = existingEntity.orElseGet(JobRequest::new);
        entity.setJobRequestStatus(this.jobRequestStatus);
        return entity;
    }
}
