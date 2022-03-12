package ru.hogwarts.rick.school_hogwarts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        return studentService.getStudent(id);
    }

    /**
     * Добавить фильтрацию студентов по возрасту.
     * GET 'http://localhost:8080/student?age=1'
     * если возраст не задан - показать всех
     */
    @GetMapping
    public Collection<Student> getStudentByAge(@RequestParam(required = false) Integer min,
                                               @RequestParam(required = false) Integer max) {
        if (min != null && max == null) {
            return studentService.getStudentsByAge(min);
        }
        if (min != null && max != null) {
            return studentService.getStudentsByAgeBetween(min, max);
        }
        return studentService.getAllStudents();
    }

    /**
     * Возможность получить количество всех студентов в школе.
     * Эндпоинт должен вернуть число.
     */
    @GetMapping("/count-all")
    public Integer CountOfAllStudents() {
        return studentService.CountOfAllStudent();
    }

    /**
     * Возможность получить средний возраст студентов.
     *
     * @return Эндпоинт должен вернуть число.
     */
    @GetMapping("/average-age")
    public Float getAverageAge() {
        return studentService.getAverageAge();
    }

    /**
     * Возможность получать только пять последних студентов.
     *
     * @return Последние студенты считаются теми, у кого идентификатор больше других.Эндпоинт должен вернуть число.
     */
    @GetMapping("/last-students")
    public Collection<Student> getLastStudents(@RequestParam Integer num) {
        return studentService.getLastStudents(num);
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
        return studentService.setStudent(student);
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
