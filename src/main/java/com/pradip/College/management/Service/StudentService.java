package com.pradip.College.management.Service;

import com.pradip.College.management.Model.Student;
import com.pradip.College.management.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    @Autowired
    StudentRepo studentRepo;
    public Student saveStudent(Student student){
        return studentRepo.save(student);
    }
}
