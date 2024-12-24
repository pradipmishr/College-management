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
    public StudentEnrollment saveStudentEnrollment(StudentEnrollment studentEnrollment) {
        return studentEnrollmentRepo.save(studentEnrollment);
    }
    public TeacherEnrollment saveTeacherEnrollment(TeacherEnrollment teacherEnrollment) {
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
    public void deleteStudentEnrollment(Long id){
        usersRepo.deleteById(id);
    }


}
