package com.pradip.College.management.Service;


import com.pradip.College.management.Model.Assignment;
import com.pradip.College.management.Model.Course;
import com.pradip.College.management.Repository.AssignmentRepo;
import com.pradip.College.management.Repository.StudentEnrollmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    AssignmentRepo assignmentRepo;
    StudentEnrollmentRepo enrollmentRepo;
    public List<Assignment> getAssignmentsForStudent(Long studentId) {
        List<Course> enrolledCourses = enrollmentRepo.findCoursesByStudentId(studentId);
        return assignmentRepo.findByCourseIn(enrolledCourses);
    }


}
