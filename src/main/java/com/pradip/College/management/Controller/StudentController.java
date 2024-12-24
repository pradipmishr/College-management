package com.pradip.College.management.Controller;

import com.pradip.College.management.Model.Users;
import com.pradip.College.management.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {


    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Users> addStudent(@RequestBody Users student) {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }


}
