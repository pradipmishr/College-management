package com.pradip.College.management.Service;

import com.pradip.College.management.Model.Course;
import com.pradip.College.management.Model.StudentEnrollment;
import com.pradip.College.management.Model.Users;
import com.pradip.College.management.Repository.CourseRepo;
import com.pradip.College.management.Repository.StudentEnrollmentRepo;
import com.pradip.College.management.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuEnrollService {

    private UsersRepo studentRepo;
    private CourseRepo courseRepo;
    private StudentEnrollmentRepo studentEnrollmentRepo;

    @Autowired
    public StuEnrollService(StudentEnrollmentRepo studentEnrollmentRepo, UsersRepo studentRepo, CourseRepo courseRepo) {
        this.studentEnrollmentRepo = studentEnrollmentRepo;
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;

    }


    public StudentEnrollment saveStudentEnrollment(Long studentId, Long courseId) {
        // Retrieve Student and Course from their respective repositories
        Users student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + courseId));

        // Create and save StudentEnrollment
        StudentEnrollment studentEnrollment = new StudentEnrollment();
        studentEnrollment.setStudent(student);
        studentEnrollment.setCourse(course);

        return studentEnrollmentRepo.save(studentEnrollment);
    }
}
