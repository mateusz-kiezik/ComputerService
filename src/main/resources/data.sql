CREATE TABLE if NOT EXISTS persistent_logins (
    username varchar(100) not null,
    series varchar(64) primary key,
    token varchar (64) not null,
    last_used timestamp not null
);

DELETE FROM user_role;
DELETE FROM roles;
DELETE FROM users;

INSERT INTO roles (id, name) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_SERVICE'),
(3, 'ROLE_USER');

INSERT INTO users (id, email, password, phone_number, first_name, last_name, city) VALUES
(1, 'boss@e-computerservice.pl', '$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS', 500600700, 'Krzysztof', 'Jarzyna', 'Szczecin'),
(2, 'service@e-computerservice.pl', '$2a$10$ByIUiNaRfBKSV6urZoBBxe4UbJ/sS6u1ZaPORHF9AtNWAuVPVz1by', 997998999, 'Adam', 'Złotarączka', 'Pacanów'),
(3, 'user@e-computerservice.pl', '$2a$10$ByIUiNaRfBKSV6urZoBBxe4UbJ/sS6u1ZaPORHF9AtNWAuVPVz1by', 159753456, 'Jan', 'Kowalski', 'Szczebrzeszyn');

INSERT INTO user_role (user_id, role_id) VALUES
(1,1),
(1,2),
(1,3),
(2,2),
(2,3),
(3,3);