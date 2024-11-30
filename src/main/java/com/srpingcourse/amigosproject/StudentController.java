package com.srpingcourse.amigosproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        if (student.getFirstName() == null) {
            return ResponseEntity.badRequest().body("First name is required.");
        }
        studentService.addStudent(student);
        return ResponseEntity.ok("Student added successfully.");
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }
}
