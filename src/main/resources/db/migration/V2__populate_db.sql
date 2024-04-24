-- Insert clients
INSERT INTO Client (name) VALUES
    ('John Smith'),
    ('Alice Johnson'),
    ('Michael Brown'),
    ('Emily Davis'),
    ('William Wilson'),
    ('Emma Taylor'),
    ('Daniel Martinez'),
    ('Olivia Anderson'),
    ('James Thomas'),
    ('Sophia Garcia');

-- Insert planets
INSERT INTO Planet (id, name) VALUES
    ('MARS', 'Mars'),
    ('VEN', 'Venus'),
    ('EAR', 'Earth'),
    ('JUP', 'Jupiter'),
    ('SAT', 'Saturn');

-- Insert tickets
INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES
    (1, 'EAR', 'MARS'),
    (2, 'VEN', 'MARS'),
    (3, 'MARS', 'JUP'),
    (4, 'JUP', 'SAT'),
    (5, 'SAT', 'MARS'),
    (6, 'MARS', 'VEN'),
    (7, 'VEN', 'EAR'),
    (8, 'JUP', 'MARS'),
    (9, 'MARS', 'SAT'),
    (10, 'SAT', 'VEN');