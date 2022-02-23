package ru.hogwarts.rick.school_hogwarts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.hogwarts.rick.school_hogwarts.model.Student;
import ru.hogwarts.rick.school_hogwarts.service.StudentService;

import java.util.Collection;

/**
 * 3. В каждом контроллере реализовать эндпоинты для создания, получения, изменения и удаления сущностей,
 * используя все правила формирования REST-запросов: GET-методы для получения данных, POST— для создания…
 */
@RestController
@RequestMapping("/student")

public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * найти по номеру
     * GET http://localhost:8080/student/1
     */
    @GetMapping("{id}")
    public Student getStudent(@PathVariable long id) {
        Student student = studentService.getStudent(id);
        if (student == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return student;
    }

    /**
     * Добавить фильтрацию студентов по возрасту.
     * GET 'http://localhost:8080/student?age=1'
     */
    @GetMapping
    public Collection<Student> getStudentUseAge(@RequestParam("age") int age) {
        Collection<Student> studentByAge = studentService.getStudentByAge(age);
        if (studentByAge.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return studentByAge;
    }

    /**
     * показать всех
     * GET http://localhost:8080/student/all
     */
    @GetMapping("/all")
    public Collection<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    /**
     * POST http://localhost:8080/student
     */
    @PostMapping
    public Student createStudent(@RequestBody Student student) {

        return studentService.addStudent(student);
    }

    /**
     * PUT http://localhost:8080/student
     */
    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        Student studentForUpdate = studentService.setStudent(student);
        if (studentForUpdate == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return studentForUpdate;
    }

    /**
     * DELETE  http://localhost:8080/student/2
     */
    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable long id) {
        studentService.removeStudent(id);
        return ResponseEntity.ok().build();
    }

}
