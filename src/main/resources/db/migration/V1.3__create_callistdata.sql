CREATE TABLE IF NOT EXISTS `staff` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `staff_name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `call_list` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `created_at` datetime DEFAULT NULL,
    `updated_at` datetime DEFAULT NULL,
                             `archive` bit(1) DEFAULT NULL,
                             `call_check` bit(1) DEFAULT NULL,
                             `call_done` bit(1) DEFAULT NULL,
                             `contact_name` varchar(255) DEFAULT NULL,
                             `contact_number` varchar(255) DEFAULT NULL,
                             `email_check` bit(1) DEFAULT NULL,
                             `email_done` bit(1) DEFAULT NULL,
                             `query` varchar(255) DEFAULT NULL,
                             `record_date` datetime DEFAULT NULL,
                             `ref_number` varchar(255) DEFAULT NULL,
    `staff_id` int(11) NOT NULL,
                             PRIMARY KEY (`id`),
    KEY `FK1mtsbur82frn64de7balymq9z` (`staff_id`),
    CONSTRAINT `FK1mtsbur82frn64de7balymq9z` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `legacy_client` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `call_id` int(11) NOT NULL,
    `call_sheet` varchar(255) DEFAULT NULL,
    `contact_number` varchar(255) DEFAULT NULL,
    `email` varchar(255) DEFAULT NULL,
    `full_name` varchar(255) DEFAULT NULL,
    `record_date` datetime DEFAULT NULL,
    `ref_number` varchar(255) DEFAULT NULL,
    `staff_name` varchar(255) DEFAULT NULL,
    `created_at` datetime DEFAULT NULL,
    `updated_at` datetime DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `staff` VALUES (1,'UNKNOWN');
INSERT INTO `staff` VALUES (2,'FILING');
INSERT INTO `staff` VALUES (3,'Amy');
INSERT INTO `staff` VALUES (4,'Dean');
INSERT INTO `staff` VALUES (5,'Daniel');
INSERT INTO `staff` VALUES (6,'Sebastian');
INSERT INTO `staff` VALUES (7,'Stacie');
