-- liquibase formatted sql

-- changeSet rickln:1
CREATE INDEX student_name_index ON student (name);

-- changeSet rickln:2
CREATE INDEX faculty_name_color_index ON faculty (name, color);