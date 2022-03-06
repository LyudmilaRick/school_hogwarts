package ru.hogwarts.rick.school_hogwarts.constants;

import ru.hogwarts.rick.school_hogwarts.model.Faculty;
import ru.hogwarts.rick.school_hogwarts.model.Student;

import java.util.Collection;
import java.util.List;

public class ConstantsForTest {
    public static final Long   ID_1     = 1L;
    public static final String NAME_1   = "Student_test1";
    public static final int    AGE_1    = 55;
    public static final Student STUDENT_1 = new Student(
            ID_1, NAME_1, AGE_1);

    public static final Long   ID_11      = 2L;
    public static final String FACULTY_1   = "Faculty_test1";
    public static final String FACULTY_2   = "Faculty_test2";
    public static final String COLOR_1     = "Color_1";
    public static final String COLOR_2     = "Color_2";

    public static final Faculty FACULTY_FIRST = new Faculty(
            ID_11, FACULTY_1, COLOR_1);
    public static final Faculty FACULTY_SECOND = new Faculty(
            ID_1,  FACULTY_2, COLOR_2);

    public static final Collection<Faculty> FACULTIES  = List.of( FACULTY_FIRST );

}
