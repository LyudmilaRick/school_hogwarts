package ru.hogwarts.rick.school_hogwarts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.hogwarts.rick.school_hogwarts.model.Faculty;
import ru.hogwarts.rick.school_hogwarts.service.FacultyService;

import java.util.Collection;

/**
 * 3. В каждом контроллере реализовать эндпоинты для создания, получения, изменения и удаления сущностей,
 * используя все правила формирования REST-запросов: GET-методы для получения данных, POST— для создания…
 */
@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    /**
     * найти по номеру
     * GET http://localhost:8080/faculty/1
     */
    @GetMapping("{id}")
    public Faculty getFaculty(@PathVariable long id) {
        return facultyService.getFaculty(id);
    }

    /**
     * Добавить фильтрацию факультетов по цвету.
     * Добавить эндпоинт для поиска факультета по имени
     * GET http://localhost:8080/faculty/?color=green
     * * показать всех - если не задан цвет
     * * GET http://localhost:8080/faculty
     */
    @GetMapping
    public Collection<Faculty> getFacultyByColor(@RequestParam(required = false) String color,
                                                 @RequestParam(required = false) String name) {
        if (color != null && !color.isBlank()) {
            return facultyService.getFacultyByColor(color);
        }
        if (name != null && !name.isBlank()) {
            return facultyService.getFacultiesByNameIgnoreCase(name);
        }
        return facultyService.getAllFaculties();
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.addFaculty(faculty);
    }

    /**
     * PUT http://localhost:8080/faculty
     */
    @PutMapping
    public Faculty updateFaculty(@RequestBody Faculty faculty) {
        return facultyService.setFaculty(faculty);
    }

    /**
     * DELETE  http://localhost:8080/faculty/2
     */
    @DeleteMapping("{id}")
    public ResponseEntity deleteFaculty(@PathVariable long id) {
        facultyService.removeFaculty(id);
        return ResponseEntity.ok().build();
    }
}
