package com.pradip.College.management.Controller;

import com.pradip.College.management.Model.Assignment;
import com.pradip.College.management.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

        @PostMapping("/addAssignment/{courseId}")
        public ResponseEntity<Assignment> createAssignment(
                @PathVariable Long courseId,
                @RequestBody Assignment assignment) {
            return new ResponseEntity<>(teacherService.addAssignment(courseId, assignment), HttpStatus.CREATED);
        }
}
