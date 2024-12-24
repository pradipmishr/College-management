package com.pradip.College.management.Service;

import com.pradip.College.management.Model.Course;
import com.pradip.College.management.Model.TeacherEnrollment;
import com.pradip.College.management.Model.Users;
import com.pradip.College.management.Repository.CourseRepo;
import com.pradip.College.management.Repository.TeacherEnrollmentRepo;
import com.pradip.College.management.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherEnrollService {

    private UsersRepo teacherRepo;
    private CourseRepo courseRepo;
    private TeacherEnrollmentRepo teacherEnrollmentRepo;
    @Autowired
    public TeacherEnrollService(TeacherEnrollmentRepo teacherEnrollmentRepo, UsersRepo teacherRepo, CourseRepo courseRepo) {
        this.teacherEnrollmentRepo = teacherEnrollmentRepo;
        this.teacherRepo = teacherRepo;
        this.courseRepo = courseRepo;

    }
    public TeacherEnrollment saveTeacherEnrollment(Long teacherId, Long courseId) {
        // Retrieve Teacher and Course from their respective repositories
        Users teacher = teacherRepo.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found with ID: " + teacherId));
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + courseId));

        // Create and save TeacherEnrollment
        TeacherEnrollment teacherEnrollment = new TeacherEnrollment();
        teacherEnrollment.setTeacher(teacher);
        teacherEnrollment.setCourse(course);

        return teacherEnrollmentRepo.save(teacherEnrollment);
    }


}
