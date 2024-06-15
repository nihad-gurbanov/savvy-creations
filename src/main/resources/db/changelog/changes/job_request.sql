CREATE TABLE `job_requests`
(
    `id`               BIGINT AUTO_INCREMENT PRIMARY KEY,
    `talent_id`        BIGINT,
    `project_id`       BIGINT,
    job_request_status VARCHAR(200),
    FOREIGN KEY (`talent_id`) REFERENCES `talents` (`id`),
    FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`)
);