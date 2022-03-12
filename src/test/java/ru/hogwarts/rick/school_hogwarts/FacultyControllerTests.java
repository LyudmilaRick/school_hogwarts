package ru.hogwarts.rick.school_hogwarts;

import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.hogwarts.rick.school_hogwarts.controller.FacultyController;
import ru.hogwarts.rick.school_hogwarts.model.Faculty;
import ru.hogwarts.rick.school_hogwarts.repository.FacultyRepository;
import ru.hogwarts.rick.school_hogwarts.service.FacultyService;
import ru.hogwarts.rick.school_hogwarts.service.FacultyServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.hogwarts.rick.school_hogwarts.constants.ConstantsForTest.*;

@WebMvcTest(controllers = FacultyController.class)
public class FacultyControllerTests {

    private Faculty faculty;
    private JSONObject facultyObject;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacultyRepository facultyRepository;

    @SpyBean
    private FacultyServiceImpl facultyServiceImpl;

    @SpyBean
    private FacultyService facultyService;

    @InjectMocks
    private FacultyController facultyController;

    @BeforeEach
    void initDataForTest() {
        faculty = new Faculty();
        faculty.setId(ID_11);
        faculty.setName(FACULTY_1);
        faculty.setColor(COLOR_1);

        facultyObject = new JSONObject();
        facultyObject.put("name", FACULTY_1);
        facultyObject.put("color", COLOR_1);
    }
    // public Faculty getFaculty
    // public Collection<Faculty> getFacultyByColor
    // public Faculty createFaculty
    // public Faculty updateFaculty
    // public ResponseEntity deleteFaculty

    @Test
    void createFacultyTest() throws Exception {
        // * POST http://localhost:8080/faculty
        when(facultyRepository.save(any(Faculty.class))).thenReturn(faculty);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/faculty")
                        .content(facultyObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ID_11))
                .andExpect(jsonPath("$.name").value(FACULTY_1))
                .andExpect(jsonPath("$.color").value(COLOR_1));

    }

    @Test
    void updateFacultyTest() throws Exception {
        // * PUT  http://localhost:8080/faculty
        when(facultyRepository.save(any(Faculty.class))).thenReturn(faculty);

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/faculty")
                        .content(facultyObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ID_11))
                .andExpect(jsonPath("$.name").value(FACULTY_1))
                .andExpect(jsonPath("$.color").value(COLOR_1));
    }

    @Test
    void deleteFacultyTest() throws Exception {
        // http://localhost:8080/faculty/2
        when(facultyRepository.findById(any(Long.class))).thenReturn(Optional.of(faculty));
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/faculty/" + ID_11))
                .andExpect(status().isOk());

    }

    @Test
    void getFacultyById() throws Exception {
        when(facultyRepository.findById(any(Long.class))).thenReturn(Optional.of(faculty));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculty/" + ID_11)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ID_11))
                .andExpect(jsonPath("$.name").value(FACULTY_1))
                .andExpect(jsonPath("$.color").value(COLOR_1));
    }

    @Test
    void getFacultyByColor() throws Exception {
        when(facultyRepository.getFacultyByColor(anyString())).thenReturn((List<Faculty>) FACULTIES);
        // * GET http://localhost:8080/faculty/?color=green
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculty/?color=" + COLOR_1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].name").value(FACULTY_1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].color").value(COLOR_1));
    }
}

