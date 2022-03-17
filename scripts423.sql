-- Составить первый JOIN-запрос,
-- чтобы получить информацию обо всех студентах
-- (достаточно получить только имя и возраст студента) школы Хогвартс вместе с названиями факультетов.
SELECT s.age, s.name, f.name
FROM student as s
LEFT JOIN faculty as f on s.faculty_id = f.id
-- Составить второй JOIN-запрос,
-- чтобы получить только тех студентов, у которых есть аватарки.
SELECT student.name
FROM avatar
INNER JOIN student on avatar.id = student_id
