CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(127) NOT NULL
);

INSERT INTO users (name) VALUES
('John Doe'),
('Jane Doe'),
('Alice Smith'),
('Bob Johnson');