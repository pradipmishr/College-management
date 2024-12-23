package com.pradip.College.management.Controller;

import com.pradip.College.management.Model.StudentEnrollment;
import com.pradip.College.management.Service.StuEnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stuEnroll")
public class StuEnrollController {
   @Autowired
    private StuEnrollService stuEnrollService;


@PostMapping("/add")
   public ResponseEntity<StudentEnrollment> addStudentEnrollment(@RequestBody StudentEnrollment studentEnrollment){
       return new ResponseEntity<>(stuEnrollService.saveStudentEnrollment(studentEnrollment), HttpStatus.CREATED);
   }
}
