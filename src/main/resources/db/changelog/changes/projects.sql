CREATE TABLE `projects`
(
    `id`                   BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name`                 VARCHAR(200) NOT NULL,
    `status`               VARCHAR(200) NOT NULL,
    `project_category`     VARCHAR(200) NOT NULL,
    `project_service_type` VARCHAR(200) NOT NULL,
    `created_at`           DATE NOT NULL,
    `requirements`         VARCHAR(1000),
    `company_id`           BIGINT NOT NULL,
    FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`)
);