-- у каждого человека есть машина
-- Причем несколько человек могут пользоваться одной машиной
-- У каждого человека есть имя, возраст и признак того, что у него есть права (или их нет)
-- У каждой машины есть марка, модель и стоимость

CREATE TABLE people
(
    id_person    INTEGER PRIMARY KEY,
    name         varchar NOT NULL,
    age          INTEGER NOT NULL,
    flag_license BOOLEAN,
    id_car       INTEGER REFERENCES cars (id_car)
);
CREATE TABLE cars
(
    id_car INTEGER PRIMARY KEY,
    trade  varchar(20) REFERENCES cars_price (trade),
    model  varchar(20) REFERENCES cars_price (model)
);

CREATE TABLE cars_price
(
    trade varchar(20) PRIMARY KEY,
    model varchar(20) PRIMARY KEY,
    price money NOT NULL
);