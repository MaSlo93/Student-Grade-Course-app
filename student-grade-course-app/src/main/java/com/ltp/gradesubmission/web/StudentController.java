package com.ltp.gradesubmission.web;

import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.service.StudentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {

    StudentService studentService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<Set<Course>> getEnrolledCourses(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getEnrolledCourses(id) ,HttpStatus.OK);
    }

}