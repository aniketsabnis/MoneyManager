-- Creating the User table
CREATE TABLE appuser (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Inserting initial users
INSERT INTO appuser (username, password) VALUES ('john_doe', 'password123');
INSERT INTO appuser (username, password) VALUES ('jane_smith', 'password456');

-- Creating the Expense table
CREATE TABLE expense (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255),
    amount DECIMAL(10, 2),
    user_id INTEGER,
    FOREIGN KEY (user_id) REFERENCES appuser (id) ON DELETE CASCADE
);

-- Inserting initial expenses
INSERT INTO expense (description, amount, user_id) VALUES ('Coffee', 4.50, 1);
INSERT INTO expense (description, amount, user_id) VALUES ('Lunch', 15.00, 1);
