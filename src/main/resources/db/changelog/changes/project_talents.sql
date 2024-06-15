CREATE TABLE `project_talents`
(
    `talent_id`  BIGINT,
    `project_id` BIGINT,
    PRIMARY KEY (`talent_id`, `project_id`),
    FOREIGN KEY (`talent_id`) REFERENCES `talents` (`id`),
    FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`)
);