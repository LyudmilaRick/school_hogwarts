-- 1. Получить всех студентов, возраст которых находится между 10 и 20 (можно подставить любые числа, главное,
-- чтобы нижняя граница была меньше верхней).
SELECT *
FROM student
WHERE age between 20 and 50;
--2.  Получить всех студентов, но отобразить только список их имен.
SELECT name
FROM student;
--3.  Получить всех студентов, у которых в имени присутствует буква «О» (или любая другая).
SELECT *
FROM student
WHERE name LIKE '%en%'
-- 4.  Получить всех студентов, у которых возраст меньше идентификатора.
SELECT *
FROM student
WHERE age < id;
-- 5. Получить всех студентов упорядоченных по возрасту.
SELECT *
FROM student
ORDER BY  age;

SELECT name, count(name)
FROM student
GROUP BY name
HAVING count(name) > 1;