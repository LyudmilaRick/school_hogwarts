package ru.hogwarts.rick.school_hogwarts.service;

import ru.hogwarts.rick.school_hogwarts.model.Student;

import java.util.Collection;

public interface StudentService {
    Student addStudent(Student student);

    Student getStudent(Long id);

    Collection<Student> getAllStudents();

    Collection<Student> getStudentByAge(int age);

    Collection<Student> getStudentByAgeBetween(int ageMin, int ageMax);

    Student setStudent(Student student);

    void removeStudent(Long id);
}