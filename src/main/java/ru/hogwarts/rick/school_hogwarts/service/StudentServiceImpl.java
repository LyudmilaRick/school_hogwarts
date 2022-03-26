package ru.hogwarts.rick.school_hogwarts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.hogwarts.rick.school_hogwarts.excepton.IdNotFoundException;
import ru.hogwarts.rick.school_hogwarts.model.Student;
import ru.hogwarts.rick.school_hogwarts.repository.StudentRepository;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService {

    Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        logger.info("Method was called - addStudent");
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        logger.info("Method was called - getStudent");
        return studentRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Информация по идентификатору не найдена" + id));
    }

    @Override
    public Collection<Student> getAllStudents() {
        Collection<Student> students = studentRepository.findAll();
        logger.info("Method was called - getStudent");
        if (students.size() == 0) {
            logger.warn("Method was stopped- getStudent");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return students;
    }

    @Override
    public Collection<Student> getStudentsByAge(int age) {
        Collection<Student> studentByAge = studentRepository.getStudentByAge(age);
        logger.info("Method was called - getStudentsByAge");
        if (studentByAge.size() == 0) {
            logger.warn("Method was stopped- getStudentsByAge");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return studentByAge;
    }

    @Override
    public Collection<Student> getStudentsByAgeBetween(int min, int max) {
        logger.info("Method was called - getStudentsByAgeBetween");
        Collection<Student> studentByAgeBetween = studentRepository.getStudentByAgeBetween(min, max);
        if (studentByAgeBetween.size() == 0) {
            logger.warn("Method was stopped - getStudentsByAgeBetween");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return studentByAgeBetween;
    }

    @Override
    public Student setStudent(Student student) {
        logger.info("Method was called - setStudent");
        return studentRepository.save(student);
    }

    @Override
    public void removeStudent(Long id) {
        logger.info("Method was called - removeStudent");
        studentRepository.deleteById(id);
    }

    /**
     * Возможность получить количество всех студентов в школе
     *
     * @return Integer  getCountOfAllStudents
     */
    @Override
    public Integer getStudentAmount() {
        logger.info("Method was called - getStudentAmount");
        return studentRepository.getStudentAmount();
    }

    /**
     * Возможность получить средний возраст студентов
     *
     * @return Float getAverageAge()
     */
    @Override
    public float getAverageAge() {
        logger.info("Method was called - getAverageAge");
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
        logger.info("Method was called - getLastStudents");
        Collection<Student> lastStudents = studentRepository.getLastStudents(num);
        if (lastStudents.size() != num) {
            logger.debug("Method was stopped - getLastStudents " + num);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return lastStudents;
    }
}

