package com.pradip.College.management.Controller;

import com.pradip.College.management.Model.Course;
import com.pradip.College.management.Model.Users;
import com.pradip.College.management.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController{
    @Autowired
    private AdminService adminService;


    // Related to student

    @PostMapping("/addStudent")
    public ResponseEntity<Users> addStudent(@RequestBody Users student) {
        return new ResponseEntity<>(adminService.saveStudent(student), HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId){
        adminService.deleteStudent(studentId);
        return ResponseEntity.ok("Student with id:"+studentId+" Deleted Successfully");
    }


    //Related to teacher
    @PostMapping("/addTeacher")
    public ResponseEntity<Users> addTeacher(@RequestBody Users teacher) {
        return new ResponseEntity<>(adminService.saveStudent(teacher), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteTeacher/{teacherId}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long teacherId){
        adminService.deleteStudent(teacherId);
        return ResponseEntity.ok("Teacher with id:" +teacherId+ " Deleted Successfully");
    }

    //Related to course


    @PostMapping("/addCourse")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        return new ResponseEntity<>(adminService.saveCourse(course), HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteCourse/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long courseId){
        adminService.deleteStudent(courseId);
        return ResponseEntity.ok("Course with id:" +courseId+ " Deleted Successfully");
    }



}
