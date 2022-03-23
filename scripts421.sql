--Возраст студента не может быть меньше 16 лет
ALTER TABLE student ADD CONSTRAINT age_constraint CHECK ( age >= 16 ) ;
-- Имена студентов должны быть уникальными и не равны нулю
ALTER TABLE student ADD CONSTRAINT UC_name UNIQUE ( name );
ALTER TABLE student ADD CONSTRAINT pk_name PRIMARY KEY ( name ) ;
ALTER TABLE student ADD primary key  ( name ) ;
-- Пара “значение названия” - “цвет факультета” должна быть уникальной
ALTER TABLE faculty
      ADD CONSTRAINT color_name_unique UNIQUE (color, name);
ALTER TABLE faculty
    ADD CONSTRAINT PK_color_name PRIMARY KEY (color, name);
-- При создании студента без возраста ему автоматически должно присваиваться 20 лет
ALTER TABLE student ALTER age SET DEFAULT 20;
