-- Create Client table
CREATE TABLE Client (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL CHECK (LENGTH(name) >= 3),
    CONSTRAINT name_length CHECK (LENGTH(name) <= 200)
);

-- Create Planet table
CREATE TABLE Planet (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(500) NOT NULL,
    CONSTRAINT valid_id CHECK (id ~ '^[A-Z0-9]+$'),
    CONSTRAINT name_length CHECK (LENGTH(name) <= 500)
);

-- Create Ticket table
CREATE TABLE Ticket (
    id SERIAL PRIMARY KEY,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    client_id INTEGER NOT NULL,
    from_planet_id VARCHAR(10) NOT NULL,
    to_planet_id VARCHAR(10) NOT NULL,
    CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES Client(id),
    CONSTRAINT fk_from_planet FOREIGN KEY (from_planet_id) REFERENCES Planet(id),
    CONSTRAINT fk_to_planet FOREIGN KEY (to_planet_id) REFERENCES Planet(id)
);