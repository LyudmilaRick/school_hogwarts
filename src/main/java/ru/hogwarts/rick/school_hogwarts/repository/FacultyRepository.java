package ru.hogwarts.rick.school_hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.rick.school_hogwarts.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
 //   List<Faculty> getFacultyByColor(String color);
}
