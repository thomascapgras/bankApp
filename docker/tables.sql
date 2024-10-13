CREATE TABLE flight (
    id SERIAL PRIMARY KEY,
    reservation_id INTEGER NOT NULL,
    departure_date TIMESTAMP NOT NULL,
    return_date TIMESTAMP NOT NULL,
    departure_city VARCHAR(255) NOT NULL,
    return_city VARCHAR(255) NOT NULL,
    seats_left INTEGER NOT NULL,
    price NUMERIC(10, 2) NOT NULL
);

CREATE TABLE reservation (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    departure_flight_id INTEGER NOT NULL,
    return_flight_id INTEGER NOT NULL,
    room_id INTEGER NOT NULL
);
