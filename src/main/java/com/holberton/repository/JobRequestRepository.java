package com.holberton.repository;

import com.holberton.domain.JobRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRequestRepository extends BaseJpaRepository<JobRequest, Long> {
    List<JobRequest> findAllByProjectId(Long projectId);

    List<JobRequest> findAllByTalentId(Long talentId);
}
