package ru.hogwarts.rick.school_hogwarts.service;

import ru.hogwarts.rick.school_hogwarts.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {
    Student addStudent(Student student);

    Student getStudent(Long id);

    Collection<Student> getAllStudents();

    Collection<Student> getStudentsByAge(int age);

    Collection<Student> getStudentsByAgeBetween(int min, int max);

    Student setStudent(Student student);

    void removeStudent(Long id);

    Integer getStudentAmount();

    Double getAverageAge();

    Collection<Student> getLastStudents(Integer num);

    List<String> findAllStartsWith(String letter);

    int getTestValue();
}