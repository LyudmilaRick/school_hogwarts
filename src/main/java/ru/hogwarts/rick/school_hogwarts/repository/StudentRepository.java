package ru.hogwarts.rick.school_hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.rick.school_hogwarts.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> getStudentByAge(int age);

    List<Student> getStudentByAgeBetween(int Min, int ageMax);
}
