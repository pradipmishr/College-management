package com.pradip.College.management.Service;

import com.pradip.College.management.Model.Course;
import com.pradip.College.management.Model.Student;
import com.pradip.College.management.Model.StudentEnrollment;
import com.pradip.College.management.Repository.CourseRepo;
import com.pradip.College.management.Repository.StudentEnrollmentRepo;

import com.pradip.College.management.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuEnrollService {

    @Autowired
    public StuEnrollService(StudentEnrollmentRepo studentEnrollmentRepo, StudentRepo studentRepo, CourseRepo courseRepo) {
        this.studentEnrollmentRepo = studentEnrollmentRepo;
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;

    }
    private StudentRepo studentRepo;
    private CourseRepo courseRepo;
    @Autowired
   private StudentEnrollmentRepo studentEnrollmentRepo;
//    public StudentEnrollment saveStudentEnrollment(StudentEnrollment studentEnrollment){
//
//        return studentEnrollmentRepo.save(studentEnrollment);
//    }

    public StudentEnrollment saveStudentEnrollment(Long studentId, Long courseId) {
        // Retrieve Student and Course from their respective repositories
        Student student = studentRepo.findById(studentId)
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
