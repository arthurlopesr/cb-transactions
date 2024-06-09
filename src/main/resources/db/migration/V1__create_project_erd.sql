CREATE TABLE IF NOT EXISTS `subscriptions_type`
(
    `subscriptions_type_id` INT            NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`                  CHAR(255)      NOT NULL,
    `access_months`         INT,
    `price`                 DECIMAL(10, 2) NOT NULL,
    `product_key`           CHAR(255)
);

CREATE TABLE IF NOT EXISTS `users`
(
    `user_id`               INT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`                  CHAR(255) NOT NULL,
    `email`                 CHAR(255) NOT NULL,
    `cpf`                   CHAR(255) NOT NULL,
    `phone`                 CHAR(255) NOT NULL,
    `subscriptions_type_id` INT
);

ALTER TABLE `users`
    ADD UNIQUE `users_email_unique` (`email`);

ALTER TABLE `users`
    ADD UNIQUE `users_cpf_unique` (`cpf`);

ALTER TABLE `users`
    ADD UNIQUE `users_phone_unique` (`phone`);

ALTER TABLE `users`
    ADD CONSTRAINT `subscriptions_type_id` FOREIGN KEY (`subscriptions_type_id`) REFERENCES `subscriptions_type` (`subscriptions_type_id`);

CREATE TABLE IF NOT EXISTS `user_credentials`
(
    `user_credential_id` INT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username`           CHAR(255) NOT NULL,
    `password`           CHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS `bank_accounts`
(
    `bank_account_id` INT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id`         INT       NOT NULL,
    `name`            CHAR(255) NOT NULL,
    `initial_balance` CHAR(255) NOT NULL,
    `type`            CHAR(255) NOT NULL,
    `color`           CHAR(255)
);

ALTER TABLE `bank_accounts`
    ADD CONSTRAINT `fk_user_id_bank_accounts` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

CREATE TABLE IF NOT EXISTS `categories`(
    `category_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` CHAR(255) NOT NULL,
    `icon` CHAR(255) NOT NULL,
    `user_id` INT NOT NULL
);

ALTER TABLE `categories`
    ADD CONSTRAINT `fk_user_id_categories` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);