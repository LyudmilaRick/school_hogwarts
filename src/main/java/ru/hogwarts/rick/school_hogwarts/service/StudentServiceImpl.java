package ru.hogwarts.rick.school_hogwarts.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.hogwarts.rick.school_hogwarts.model.Student;
import ru.hogwarts.rick.school_hogwarts.repoository.StudentRepository;

import java.util.Collection;


@Service
public class StudentServiceImpl implements StudentService {

    private  StudentRepository studentRepository;

    public StudentServiceImpl(@Qualifier("studentRepository")StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public StudentServiceImpl() {
    }
    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

  //  @Override
//   public Collection<Student> getStudentByAge(int age) {
 //       return studentRepository.getStudentByAge(age);
 //   }

    @Override
    public Student setStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void removeStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

