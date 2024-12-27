package com.pradip.College.management.Service;

import com.pradip.College.management.ExceptionHandler.ResourceNotFoundException;
import com.pradip.College.management.Model.Assignment;
import com.pradip.College.management.Model.Submission;
import com.pradip.College.management.Model.Users;
import com.pradip.College.management.Repository.AssignmentRepo;
import com.pradip.College.management.Repository.SubmissionRepo;
import com.pradip.College.management.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SubmissionService {
    @Autowired
    SubmissionRepo submissionRepo;
    @Autowired
    AssignmentRepo assignmentRepo;
    @Autowired
    UsersRepo userRepo;
    public Submission submitAssignment(Long assignmentId, Long studentId, Submission submissionDetails) {
        Assignment assignment = assignmentRepo.findById(assignmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Assignment not found"));
        Users student = userRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        submissionDetails.setAssignment(assignment);
        submissionDetails.setStudent(student);
        submissionDetails.setSubmissionDate(LocalDateTime.now());
        return submissionRepo.save(submissionDetails);
    }

}
