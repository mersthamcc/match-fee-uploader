CREATE TABLE IF NOT EXISTS payment (
    id SERIAL,
    created TIMESTAMP NOT NULL,
    order_number TEXT NOT NULL,
    category TEXT NULL,
    product TEXT NOT NULL,
    price DECIMAL(5,2) NOT NULL,
    "type" TEXT NOT NULL,
    line_number INTEGER NOT NULL,
    matched_artefact TEXT NULL,
    sage_id TEXT NULL,
    PRIMARY KEY (id)
);
