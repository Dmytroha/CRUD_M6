INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES ('John Doe', '1990-03-05', 'Junior', 2000),
       ('Jane Smith', '1985-02-21', 'Senior', 6000),
       ('Bob Johnson', '1992-06-03', 'Middle', 4000),
       ('Alice Williams', '1993-05-26', 'Trainee', 1500),
       ('Charlie Brown', '1988-07-05', 'Senior', 7000),
       ('Dave Davis', '1991-09-18', 'Junior', 2500),
       ('Eve Evans', '1987-07-24', 'Middle', 4500),
       ('Frank Foster', '1994-08-16', 'Trainee', 1200),
       ('Grace Green', '1986-09-20', 'Senior', 7000),
       ('Henry Hall', '1995-04-22', 'Junior', 3000);

INSERT INTO client (NAME)
VALUES ('Max Berry'),
       ('Amanda Litz'),
       ('Rhon Salevan'),
       ('Mikki Shulz'),
       ('Tuko Salamanca');


INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE)
VALUES (1, '2022-01-01', '2023-03-01'),
       (1, '2022-02-01', '2023-01-01'),
       (2, '2022-03-01', '2023-04-01'),
       (2, '2022-04-01', '2022-11-01'),
       (3, '2022-05-01', '2022-12-01'),
       (3, '2022-06-01', '2023-06-01'),
       (4, '2022-07-01', '2023-07-01'),
       (4, '2022-08-01', '2023-09-01'),
       (5, '2022-09-01', '2023-06-01'),
       (5, '2022-07-01', '2023-10-01');


INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (3, 6),
       (3, 7),
       (4, 8),
       (4, 9),
       (5, 10),
       (6, 1),
       (6, 2),
       (7, 3),
       (7, 4),
       (8, 5),
       (8, 6),
       (9, 7),
       (9, 8),
       (10, 9),
       (10, 10);

