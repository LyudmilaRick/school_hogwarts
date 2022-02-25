package ru.hogwarts.rick.school_hogwarts.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.hogwarts.rick.school_hogwarts.excepton.IdNotFoundException;
import ru.hogwarts.rick.school_hogwarts.model.Faculty;
import ru.hogwarts.rick.school_hogwarts.repository.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    /**
     * найти по идентификатору
     *
     * @param id long
     * @return Faculty
     */
    @Override
    public Faculty getFaculty(Long id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Информация по идентификатору не найдена" + id));
    }

    /**
     * показать всех
     *
     * @return Collection<Faculty>
     */
    @Override
    public Collection<Faculty> getAllFaculties() {
        Collection<Faculty> faculties = facultyRepository.findAll();
        if (faculties.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return faculties;
    }

    /**
     * Добавить фильтрацию факультетов по цвету.
     */
    @Override
    public Collection<Faculty> getFacultyByColor(String color) {
        Collection<Faculty> facultyByColor = facultyRepository.getFacultyByColor(color);
        if (facultyByColor.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return facultyByColor;
    }

    @Override
    public Faculty setFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public void removeFaculty(Long id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public Collection<Faculty> getFacultiesByNameIgnoreCase(String name) {
        Collection<Faculty> facultyByName = facultyRepository.getFacultiesByNameIgnoreCase(name);
        if (facultyByName.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return facultyByName;
    }
}


