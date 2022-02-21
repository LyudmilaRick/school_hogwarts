package ru.hogwarts.rick.school_hogwarts.repoository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.rick.school_hogwarts.model.Faculty;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> getFacultyUseColor(String color);
}
