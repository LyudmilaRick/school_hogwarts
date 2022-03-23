package ru.hogwarts.rick.school_hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.rick.school_hogwarts.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> getStudentByAge(int age);

    List<Student> getStudentByAgeBetween(int Min, int ageMax);

    @Query(value = "SELECT COUNT(DISTINCT name)  FROM student" , nativeQuery = true)
    Integer getCountOfAllStudents();

    @Query(value = "SELECT AVG(age)  FROM student" , nativeQuery = true)
    Float getAverageAge();

    @Query(value = "SELECT *  FROM student ORDER BY id DESC LIMIT ?1", nativeQuery = true)
    List<Student> getLastStudents(Integer num);
}
