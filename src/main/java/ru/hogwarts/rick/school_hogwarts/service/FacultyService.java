package ru.hogwarts.rick.school_hogwarts.service;

import ru.hogwarts.rick.school_hogwarts.model.Faculty;

import java.util.Collection;

public interface FacultyService {
    Faculty addFaculty(Faculty faculty);

    Faculty getFaculty(Long id);

    Collection<Faculty> getAllFaculties();

    Collection<Faculty> getFacultyUseColor(String color);

    Faculty setFaculty(Faculty faculty);

    void removeFaculty(Long id);
}