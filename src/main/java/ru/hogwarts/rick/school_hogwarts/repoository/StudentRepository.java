package ru.hogwarts.rick.school_hogwarts.repoository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.rick.school_hogwarts.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> getStudentUseAge(int age);
}
