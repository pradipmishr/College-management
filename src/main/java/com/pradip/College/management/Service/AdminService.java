package com.pradip.College.management.Service;

import com.pradip.College.management.Model.Course;
import com.pradip.College.management.Model.StudentEnrollment;
import com.pradip.College.management.Model.TeacherEnrollment;
import com.pradip.College.management.Model.Users;
import com.pradip.College.management.Repository.CourseRepo;
import com.pradip.College.management.Repository.StudentEnrollmentRepo;
import com.pradip.College.management.Repository.TeacherEnrollmentRepo;
import com.pradip.College.management.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private UsersRepo usersRepo;
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private StudentEnrollmentRepo studentEnrollmentRepo;
    @Autowired
    private TeacherEnrollmentRepo teacherEnrollmentRepo;


    //Save methods
    public Users saveUsers(Users users){
        return usersRepo.save(users);
    }
    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }
    public StudentEnrollment saveStudentEnrollment(Long studentId, Long courseId) {
        // Retrieve Student and Course from their respective repositories
        Users student = usersRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + courseId));

        // Create and save StudentEnrollment
        StudentEnrollment studentEnrollment = new StudentEnrollment();
        studentEnrollment.setStudent(student);
        studentEnrollment.setCourse(course);

        return studentEnrollmentRepo.save(studentEnrollment);
    }
    public TeacherEnrollment saveTeacherEnrollment(Long teacherId, Long courseId) {
        // Retrieve Student and Course from their respective repositories
        Users teacher = usersRepo.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("teacher not found with ID: " + teacherId));
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + courseId));

        // Create and save StudentEnrollment
        TeacherEnrollment teacherEnrollment = new TeacherEnrollment();
        teacherEnrollment.setTeacher(teacher);
        teacherEnrollment.setCourse(course);

        return teacherEnrollmentRepo.save(teacherEnrollment);
    }



    // Deletion methods
    public void deleteTeacher(Long id){
        usersRepo.deleteById(id);
    }
    public void deleteStudent(Long id){
        usersRepo.deleteById(id);
    }
    public void deleteCourse(Long id){
        usersRepo.deleteById(id);
    }
    public void deleteStudentEnrollment(Long sid,Long cid){
        studentEnrollmentRepo.deleteByStudentIdAndCourseId(sid,cid);
    }
    public void deleteTeacherEnrollment(Long tid, Long cid){
        teacherEnrollmentRepo.deleteByTeacherIdAndCourseId(tid,cid);
    }


}
