package com.pradip.College.management.Controller;

import com.pradip.College.management.Model.Course;
import com.pradip.College.management.Model.StudentEnrollment;
import com.pradip.College.management.Model.TeacherEnrollment;
import com.pradip.College.management.Model.Users;
import com.pradip.College.management.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController{

    private AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }


    // Related to users

    @PostMapping("/addUser")
    public ResponseEntity<Users> addUser(@RequestBody Users student) {
        return new ResponseEntity<>(adminService.saveUsers(student), HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        adminService.deleteStudent(userId);
        return ResponseEntity.ok("User with id:"+userId +" Deleted Successfully");
    }


    //Related to course

    @PostMapping("/addCourse")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        return new ResponseEntity<>(adminService.saveCourse(course), HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteCourse/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long courseId){
        adminService.deleteCourse(courseId);
        return ResponseEntity.ok("Course with id:" +courseId+ " Deleted Successfully");
    }

    //Related to Student Enrollment
    @PostMapping("/addStudentEnrollment/{studentId}/{courseId}")
    public ResponseEntity<StudentEnrollment> addStudentEnrollment(@PathVariable Long studentId, @PathVariable Long courseId) {
        return new ResponseEntity<>(adminService.saveStudentEnrollment(studentId,courseId), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteStudentEnrollment/{studentId}/{courseId}")
    public ResponseEntity<String> deleteStudentEnrollment(@PathVariable Long studentId, @PathVariable Long courseId){
        adminService.deleteStudentEnrollment(studentId,courseId);
        return ResponseEntity.ok("Student with id:" +studentId+ " and course with id:"+courseId+ " Unenrolled Successfully");
    }




    //Related to Teacher Enrollment
    @PostMapping("/addTeacherEnrollment/{teacherId}/{courseId}")
    public ResponseEntity<TeacherEnrollment> addTeacherEnrollment(@PathVariable Long teacherId, @PathVariable Long courseId) {
        return new ResponseEntity<>(adminService.saveTeacherEnrollment(teacherId,courseId), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteTeacherEnrollment/{teacherId}/{courseId}")
    public ResponseEntity<String> deleteTeacherEnrollment(@PathVariable Long teacherId, @PathVariable Long courseId){
        adminService.deleteTeacherEnrollment(teacherId,courseId);
        return ResponseEntity.ok("Teacher with id:" +teacherId+ " and course with id:"+courseId+ " Unenrolled Successfully");
    }
}
