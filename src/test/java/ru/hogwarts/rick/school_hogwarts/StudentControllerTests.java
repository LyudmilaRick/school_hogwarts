package ru.hogwarts.rick.school_hogwarts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.hogwarts.rick.school_hogwarts.controller.StudentController;
import ru.hogwarts.rick.school_hogwarts.model.Student;

import java.util.Collection;

import static ru.hogwarts.rick.school_hogwarts.constants.ConstantsForTest.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTests {
    private Student testStudent;
    private Long idTestStudent;
    @LocalServerPort
    private int port;

    @Autowired
    private StudentController studentController;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void initTestData() {
        testStudent = new Student();
        testStudent.setName("testStudent");
        testStudent.setAge(27);
    }

    @Test
    void contextLoads() throws Exception {
        Assertions.assertThat(studentController).isNotNull();
    }

//  public Student getStudent(@PathVariable long id)
//  public Collection<Student> getStudentByAge
//  public Student createStudent
//  public Student updateStudent
//  public ResponseEntity deleteStudent

    @Test
    void getStudentByIdTest() throws Exception {
        //GET http://localhost:8080/student/1
        idTestStudent = restTemplate.postForObject(getUrl(), testStudent, Student.class).getId();
        testStudent.setId(idTestStudent);

        Assertions.assertThat(this.restTemplate.getForObject(getUrl() + idTestStudent, Student.class))
                .isEqualTo(testStudent);

    }

    @Test
    void getAllStudentTest() throws Exception {
        //GET http://localhost:8080/student/
        Assertions.assertThat(this.restTemplate.getForObject(getUrl(), Collection.class))
                .isNotEmpty();
        Assertions.assertThat(this.restTemplate.getForObject(getUrl(), Collection.class))
                .hasSizeGreaterThanOrEqualTo(1);
        Assertions.assertThat(this.restTemplate.getForObject(getUrl(), Collection.class).toString())
                .contains(testStudent.getName());
    }

    @Test
    void createStudentTest() throws Exception {
        // POST http://localhost:8080/student
        Assertions.assertThat(this.restTemplate.postForObject(getUrl(), testStudent, String.class))
                .isNotNull();

    }

    @Test
    void deleteStudentTest() throws Exception {
        //  http://localhost:8080/student/2
        idTestStudent = restTemplate.postForObject(getUrl(), testStudent, Student.class).getId();
        testStudent.setId(idTestStudent);

        Assertions.assertThat(this.restTemplate.getForObject(getUrl() + idTestStudent, Student.class))
                .isEqualTo(testStudent);

        restTemplate.delete(getUrl() + idTestStudent);
        ResponseEntity<Student> empty = restTemplate.getForEntity(getUrl() + idTestStudent, Student.class);
        Assertions.assertThat(empty.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

    }

    @Test
    void updateStudentTest() throws Exception {
        //  http://localhost:8080/student/
        testStudent.setId(ID_1);
        testStudent.setName(NAME_1);
        testStudent.setAge(AGE_1);

        restTemplate.put(getUrl(), testStudent);

        Assertions.assertThat(this.restTemplate.getForObject(getUrl() + ID_1, Student.class))
                .isEqualTo(STUDENT_1);

    }

    @Test
    void getStudentByAgeTest() throws Exception {
        //GET http://localhost:8080/student/55
        Assertions.assertThat(this.restTemplate.getForObject(getUrl() + "?age=" + AGE_1, Collection.class))
                .isNotNull();
    }

    private String getUrl() {
        return "http://localhost:" + port + "/student/";
    }


}
