package com.pradip.College.management.Repository;

import com.pradip.College.management.Model.TeacherEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherEnrollmentRepo extends JpaRepository<TeacherEnrollment, Long> {
    void deleteByTeacherIdAndCourseId(Long tid, Long cid);
}
