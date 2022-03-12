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
    public Collection<Student> getStudentsByAge(int age) {
        Collection<Student> studentByAge = studentRepository.getStudentByAge(age);
        if (studentByAge.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return studentByAge;
    }

    @Override
    public Collection<Student> getStudentsByAgeBetween(int min, int max) {
        Collection<Student> studentByAgeBetween = studentRepository.getStudentByAgeBetween(min, max);
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

    /**
     * Возможность получить количество всех студентов в школе
     *
     * @return Integer  getCountOfAllStudents
     */
    @Override
    public Integer CountOfAllStudent() {
        return studentRepository.getCountOfAllStudents();
    }

    /**
     * Возможность получить средний возраст студентов
     *
     * @return Float getAverageAge()
     */
    @Override
    public Float getAverageAge() {
        return studentRepository.getAverageAge();
    }

    /**
     * Возможность получать только пять последних студентов
     * Последние студенты считаются теми, у кого идентификатор больше других.
     *
     * @param num пять
     * @return только пять последних студентов
     */
    @Override
    public Collection<Student> getLastStudents(Integer num) {
        Collection<Student> lastStudents = studentRepository.getLastStudents(num);
        if (lastStudents.size() != num) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return lastStudents;
    }
}

