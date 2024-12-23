package com.pradip.College.management.Controller;

import com.pradip.College.management.Model.StudentEnrollment;
import com.pradip.College.management.Service.StuEnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stuEnroll")
public class StuEnrollController {
   @Autowired
    private StuEnrollService stuEnrollService;


@PostMapping("/add/{studentId},{courseId}")
   public ResponseEntity<StudentEnrollment> addStudentEnrollment(@RequestParam Long studentId, @RequestParam Long courseId){
       return new ResponseEntity<>(stuEnrollService.saveStudentEnrollment(studentId,courseId), HttpStatus.CREATED);
   }
}
