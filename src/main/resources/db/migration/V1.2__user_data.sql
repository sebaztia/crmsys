INSERT INTO user (id, username, email, password) VALUES (501, 'ad', 'ad', '$2a$10$P4ycj/nZ3jqZpuoZIhiGTeg7aianJeE.1pJ1TMrtu8YxA1sn8GHmK');

INSERT INTO role (id, name) VALUES (501, 'ADMIN');
INSERT INTO role (id, name) VALUES (601, 'ROLE_USER');

INSERT INTO users_roles (user_id, role_id) VALUES (501, 501);