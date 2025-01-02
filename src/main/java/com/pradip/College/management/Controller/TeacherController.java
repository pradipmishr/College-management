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
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private AssignmentService assignmentService;
    @Autowired
    private SubmissionService submissionService;

        @PostMapping("/addAssignment/{courseId}")
        public ResponseEntity<Assignment> createAssignment(
                @PathVariable Long courseId,
                @RequestBody Assignment assignment) {
            return new ResponseEntity<>(assignmentService.addAssignment(courseId, assignment), HttpStatus.CREATED);
        }
    // Teacher views all assignments for a specific course
    @GetMapping("/assignments/{courseId}")
    public ResponseEntity<List<Assignment>> getAssignmentsByCourse(@PathVariable Long courseId) {
        List<Assignment> assignments = assignmentService.getAssignmentsByCourse(courseId);
        return ResponseEntity.ok(assignments);
    }

    // Teacher views all submissions for a specific assignment
//    @GetMapping("/submissions/{assignmentId}")
//    public ResponseEntity<List<Submission>> getSubmissionsByAssignment(@PathVariable Long assignmentId) {
//        List<Submission> submissions = submissionService.getSubmissionsByAssignment(assignmentId);
//        return ResponseEntity.ok(submissions);
//    }
//
//    // Teacher grades a submission
//    @PutMapping("/submission/grade/{submissionId}")
//    public ResponseEntity<Submission> gradeSubmission(
//            @PathVariable Long submissionId,
//            @RequestParam int grade) {
//        Submission gradedSubmission = submissionService.gradeSubmission(submissionId, grade);
//        return ResponseEntity.ok(gradedSubmission);
//    }
}
