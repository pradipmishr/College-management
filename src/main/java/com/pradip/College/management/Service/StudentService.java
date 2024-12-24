package com.pradip.College.management.Service;

import com.pradip.College.management.Model.Users;
import com.pradip.College.management.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    @Autowired
    UsersRepo studentRepo;
    public Users saveStudent(Users student){
        return studentRepo.save(student);
    }
}
