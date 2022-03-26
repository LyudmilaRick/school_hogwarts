package ru.hogwarts.rick.school_hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.rick.school_hogwarts.model.Faculty;

import java.util.List;

/**
 * Добавьте пагинацию для репозитория,
 * чтобы можно было получать списки постранично.
 */
@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> getFacultyByColor(String color);
    List<Faculty> getFacultiesByNameIgnoreCase(String name);
}

