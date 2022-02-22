package ru.hogwarts.rick.school_hogwarts.repoository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.rick.school_hogwarts.model.Faculty;

import java.util.List;
@Repository("facultyRepository")
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
 //   List<Faculty> getFacultyByColor(String color);
}
