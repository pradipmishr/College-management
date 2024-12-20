package com.pradip.College.management.Service;

import com.pradip.College.management.Model.Student;
import com.pradip.College.management.Model.StudentEnrollment;
import com.pradip.College.management.Repository.StudentEnrollmentRepo;
import com.pradip.College.management.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuEnrollService {

    @Autowired
    StudentEnrollmentRepo studentEnrollmentRepo;
    public StudentEnrollment saveStudentEnrollment(StudentEnrollment studentEnrollment){
        return StudentEnrollmentRepo.save(studentEnrollment);
    }
}
