package ru.hogwarts.rick.school_hogwarts.service;

import ru.hogwarts.rick.school_hogwarts.model.Student;

import java.util.Collection;

public interface StudentService {
    Student addStudent(Student student);

    Student getStudent(Long id);

    Collection<Student> getAllStudents();

    Collection<Student> getStudentsByAge(int age);

    Collection<Student> getStudentsByAgeBetween(int min, int max);

    Student setStudent(Student student);

    void removeStudent(Long id);

    Integer getStudentAmount();

    float getAverageAge();

    Collection<Student> getLastStudents(Integer num);
}