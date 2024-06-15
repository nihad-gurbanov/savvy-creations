CREATE TABLE `companies`
(
    `id`           BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name`         VARCHAR(100) NOT NULL,
    `surname`      VARCHAR(100) NOT NULL,
    `phone_number` VARCHAR(50),
    `location`     VARCHAR(100),
    `company_type` VARCHAR(100),
    `about`        VARCHAR(1000),
    `company_name` VARCHAR(100) NOT NULL,
    `created_at`   DATE NOT NULL,
    `user_id`      BIGINT,
    FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);