package com.pradip.College.management.Service;

import com.pradip.College.management.ExceptionHandler.ResourceNotFoundException;
import com.pradip.College.management.Model.Assignment;
import com.pradip.College.management.Model.Course;
import com.pradip.College.management.Repository.AssignmentRepo;
import com.pradip.College.management.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    AssignmentRepo assignmentRepo;
    public Assignment addAssignment(Long courseId, Assignment assignmentDetails) {
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        assignmentDetails.setCourse(course);
        return assignmentRepo.save(assignmentDetails);
    }

}
