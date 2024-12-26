package com.pradip.College.management.Repository;

import com.pradip.College.management.Model.TeacherEnrollment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherEnrollmentRepo extends JpaRepository<TeacherEnrollment, Long> {
//    @Modifying
//    @Transactional
//    @Query("delete from teacherEnrollment t where t.teacher.id = ?1 and t.course.id = ?2")
    @Transactional
    void deleteByTeacherIdAndCourseId(Long tid, Long cid);
}
