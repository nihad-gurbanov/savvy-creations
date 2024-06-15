CREATE TABLE `talents`
(
    `id`            BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name`          VARCHAR(100) NOT NULL,
    `surname`       VARCHAR(100) NOT NULL,
    `created_at`    DATE NOT NULL,
    `phone_number`  VARCHAR(50),
    `location`      VARCHAR(100),
    `about`         VARCHAR(1000),
    `user_id`       BIGINT NOT NULL,
    `profession_id` BIGINT NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
    FOREIGN KEY (`profession_id`) REFERENCES `professions` (`id`)
);