CREATE TABLE IF NOT EXISTS client (
    id SERIAL,
    namecli VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS bill (
    id SERIAL,
    ruc INT NOT NULL,
    company VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL,
    total INT NOT NULL,
    client_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY ( client_id ) REFERENCES client(id)
    );