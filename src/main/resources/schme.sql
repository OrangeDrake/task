CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(127) NOT NULL
);

INSERT INTO users (name) VALUES
('John Doe'),
('Jane Doe'),
('Alice Smith'),
('Bob Johnson');


ALTER TABLE users
ADD COLUMN username VARCHAR(127),
ADD COLUMN password VARCHAR(255);

UPDATE users
SET username = regexp_replace(name, '\s', '', 'g'),
    password = substring(md5(random()::text) from 1 for 12);

ALTER TABLE users
ALTER COLUMN username SET NOT NULL,
ALTER COLUMN password SET NOT NULL,
ADD CONSTRAINT unique_username UNIQUE (username);
