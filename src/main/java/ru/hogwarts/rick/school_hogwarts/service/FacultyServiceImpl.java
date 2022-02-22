package ru.hogwarts.rick.school_hogwarts.service;

import org.springframework.stereotype.Service;
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
        return facultyRepository.findById(id).get();
    }

    /**
     * показать всех
     *
     * @return Collection<Faculty>
     */
    @Override
    public Collection<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    /**
     * Добавить фильтрацию факультетов по цвету.
     */
    //   @Override
    //   public Collection<Faculty> getFacultyByColor(String color) {
    //       return facultyRepository.getFacultyByColor(color);
    //   }
    @Override
    public Faculty setFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public void removeFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}

