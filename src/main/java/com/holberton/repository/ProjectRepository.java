package com.holberton.repository;

import com.holberton.domain.Project;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProjectRepository extends BaseJpaRepository<Project, Long> {
    @Query("SELECT p FROM Project p JOIN p.talents t WHERE t.id = :talentId")
    List<Project> findProjectsByTalentId(@Param("talentId") Long talentId);
    List<Project> findAllByCompanyId(Long companyId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO project_talents (talent_id, project_id) VALUES (:talentId, :projectId)", nativeQuery = true)
    void addTalentToProject(@Param("talentId") Long talentId, @Param("projectId") Long projectId);
}
