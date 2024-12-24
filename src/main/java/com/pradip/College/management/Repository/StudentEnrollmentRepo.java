package com.pradip.College.management.Repository;

import com.pradip.College.management.Model.StudentEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEnrollmentRepo extends JpaRepository<StudentEnrollment,Long> {
    void deleteByStudentIdAndCourseId(Long sid, Long cid);
}
