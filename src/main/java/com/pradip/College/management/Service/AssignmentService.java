package com.pradip.College.management.Service;

import com.pradip.College.management.ExceptionHandler.ResourceNotFoundException;
import com.pradip.College.management.Model.Assignment;
import com.pradip.College.management.Model.Course;
import com.pradip.College.management.Repository.AssignmentRepo;
import com.pradip.College.management.Repository.CourseRepo;
import com.pradip.College.management.Repository.StudentEnrollmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssignmentService {
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    AssignmentRepo assignmentRepo;
    @Autowired
    StudentEnrollmentRepo enrollmentRepo;

    // For teachers
    public Assignment addAssignment(Long courseId, Assignment assignmentDetails) {
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        assignmentDetails.setCourse(course);
        return assignmentRepo.save(assignmentDetails);
    }


    //For students
    public List<Assignment> getAssignmentsForStudent(Long studentId) {
        List<Course> enrolledCourses = enrollmentRepo.findCoursesByStudentId(studentId);
        return assignmentRepo.findByCourseIn(enrolledCourses);
    }

    public List<Assignment> getAssignmentsByCourse(Long courseId) {
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        return assignmentRepo.findByCourse(course);
    }
}
