package ru.hogwarts.rick.school_hogwarts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.hogwarts.rick.school_hogwarts.excepton.IdNotFoundException;
import ru.hogwarts.rick.school_hogwarts.model.Faculty;
import ru.hogwarts.rick.school_hogwarts.repository.FacultyRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final Logger logger = LoggerFactory.getLogger(FacultyServiceImpl.class);
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
        logger.info("Method was called - getFaculty");
        return facultyRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Информация по идентификатору не найдена" + id));
    }

    /**
     * показать всех
     *
     * @return Collection<Faculty>
     */
    @Override
    public Collection<Faculty> getAllFaculties(int pageNumber, int pageSize) {
        logger.info("Method was called - getAllFaculties");
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        Collection<Faculty> faculties = facultyRepository.findAll(pageRequest).getContent();
        if (faculties.size() == 0) {
            logger.warn("Method was stopped - getAllFaculties");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return faculties;
    }

    /**
     * Добавить фильтрацию факультетов по цвету.
     */
    @Override
    public Collection<Faculty> getFacultyByColor(String color) {
        logger.info("Method was called - getFacultyByColor");
        Collection<Faculty> facultyByColor = facultyRepository.getFacultyByColor(color);
        if (facultyByColor.size() == 0) {
            logger.warn("Color was not founded - " + color);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return facultyByColor;
    }

    @Override
    public Faculty setFaculty(Faculty faculty) {
        logger.info("Method was called - setFaculty");
        return facultyRepository.save(faculty);
    }

    @Override
    public void removeFaculty(Long id) {
        logger.info("Method was called - removeFaculty");
        facultyRepository.deleteById(id);
    }

    @Override
    public Collection<Faculty> getFacultiesByNameIgnoreCase(String name) {
        logger.info("Method was called - getFacultiesByNameIgnoreCase");
        Collection<Faculty> facultyByName = facultyRepository.getFacultiesByNameIgnoreCase(name);
        if (facultyByName.size() == 0) {
            logger.warn("Name was not founded - " + name);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return facultyByName;
    }

    /**
     * Создать эндпоинт, который будет возвращать самое длинное название факультета
     *
     * @return List<Faculty> - может быть несколько записей, поэтому верну List
     * первый проход - найти  максимальную длину
     * второй - вывести всех с этой длиной - можно распараллелить
     */
    @Override
    public List<Faculty> getMaxFacultiesName() {
        logger.info("Method was called - getMaxFacultiesName");
        // можно распараллетиь подсчет длины
        int lenName = facultyRepository.findAll().stream()
                .parallel()
                .mapToInt(p -> p.getName().length())
                .max().getAsInt();
        logger.info("Length was found - " + lenName);
        // можно распараллелить поиск
        return facultyRepository.findAll().stream()
                .parallel()
                .filter(p -> p.getName().length() == lenName)
                .collect(Collectors.toList())
                ;
    }
}


