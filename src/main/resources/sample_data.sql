CREATE SCHEMA IF NOT EXISTS doa_test;
CREATE TABLE doa_test.PERSONS (
                         name VARCHAR(50) NOT NULL,
                         surname VARCHAR(50) NOT NULL,
                         age INTEGER NOT NULL,
                         phone_number VARCHAR(20),
                         city_of_living VARCHAR(50),
                         PRIMARY KEY (name, surname, age)
);

INSERT INTO doa_test.PERSONS (name, surname, age, phone_number, city_of_living)
VALUES ('Ivan', 'Ivanov', 30, '89001234567', 'Moscow'),
       ('Petr', 'Petrov', 25, '89123456789', 'Moscow'),
       ('Olga', 'Smirnova', 35, '89234567890', 'Saint Petersburg');