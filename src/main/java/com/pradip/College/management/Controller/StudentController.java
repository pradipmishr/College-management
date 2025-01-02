package com.pradip.College.management.Controller;

import com.pradip.College.management.Model.Assignment;
import com.pradip.College.management.Model.Submission;
import com.pradip.College.management.Service.AssignmentService;
import com.pradip.College.management.Service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private AssignmentService assignmentService;
    @Autowired
    private SubmissionService submissionService;


    // Student views assignments for their enrolled courses
    @GetMapping("/assignments/{studentId}")
    public ResponseEntity<List<Assignment>> getAssignmentsForStudent(@PathVariable Long studentId) {
        List<Assignment> assignments = assignmentService.getAssignmentsForStudent(studentId);
        return ResponseEntity.ok(assignments);
    }

    // Student submits an assignment
    @PostMapping("/submission/{studentId}/{assignmentId}")
    public ResponseEntity<Submission> submitAssignment(
            @PathVariable Long studentId,
            @PathVariable Long assignmentId,
            @RequestBody Submission submission) {
        return new ResponseEntity<Submission>(submissionService.submitAssignment(studentId, assignmentId, submission), HttpStatus.CREATED);
    }

    // Student views their submissions
    @GetMapping("/submissions/{studentId}")
    public ResponseEntity<List<Submission>> getSubmissionsForStudent(@PathVariable Long studentId) {
        List<Submission> submissions = submissionService.getSubmissionsForStudent(studentId);
        return ResponseEntity.ok(submissions);
    }


}
