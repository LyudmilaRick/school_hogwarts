package ru.hogwarts.rick.school_hogwarts.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.hogwarts.rick.school_hogwarts.excepton.IdNotFoundException;
import ru.hogwarts.rick.school_hogwarts.model.Faculty;
import ru.hogwarts.rick.school_hogwarts.model.Student;
import ru.hogwarts.rick.school_hogwarts.repository.StudentRepository;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Информация по идентификатору не найдена" + id));
    }

    @Override
    public Collection<Student> getAllStudents() {
        Collection<Student> students = studentRepository.findAll();
        if (students.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return students;
    }

    @Override
    public Collection<Student> getStudentByAge(int age) {
        Collection<Student> studentByAge = studentRepository.getStudentByAge(age);
        if (studentByAge.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return studentByAge;
    }

    @Override
    public Collection<Student> getStudentByAgeBetween(int ageMin, int ageMax) {
        Collection<Student> studentByAgeBetween = studentRepository.getStudentByAgeBetween(ageMin, ageMax);
        if (studentByAgeBetween.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return studentByAgeBetween;
    }

    @Override
    public Student setStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void removeStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

