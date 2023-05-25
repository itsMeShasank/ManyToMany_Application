package com.epam.manytomany_application.controller;

import com.epam.manytomany_application.jpa.CourseRepo;
import com.epam.manytomany_application.jpa.StudentRepo;
import com.epam.manytomany_application.model.Course;
import com.epam.manytomany_application.model.Student;
import com.epam.manytomany_application.model.StudentDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPIDefinition(info = @Info(title = "Many-To-Many Mapping"))
@RestController
public class Controller {

    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;

    private final ModelMapper modelMapper;

    private final TypeToken<List<StudentDto>> typeToken;

    private final TypeToken<List<Course>> coursetypeToken;
    public Controller(StudentRepo studentRepo, CourseRepo courseRepo, ModelMapper modelMapper, TypeToken<List<StudentDto>> typeToken, TypeToken<List<Course>> coursetypeToken) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
        this.modelMapper = modelMapper;
        this.typeToken = typeToken;
        this.coursetypeToken = coursetypeToken;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> testingMethodHandler() {
        return ResponseEntity.status(HttpStatus.OK).body("hello Welcome...");
    }

    @PostMapping("/add")
    public ResponseEntity<StudentDto> assignStudent(@RequestBody StudentDto studentDto) {
        studentRepo.save(modelMapper.map(studentDto,Student.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(studentDto);
    }

    @PutMapping("/update")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto student) {
        Student student1 = new Student(student.getId(),student.getName(),modelMapper.map(student.getCourses(),coursetypeToken.getType()));
        studentRepo.save(student1);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(studentRepo.findAll(),typeToken.getType()));
    }
}
