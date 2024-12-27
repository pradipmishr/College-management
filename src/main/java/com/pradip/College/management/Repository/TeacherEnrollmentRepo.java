package com.pradip.College.management.Repository;

import com.pradip.College.management.Model.TeacherEnrollment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherEnrollmentRepo extends JpaRepository<TeacherEnrollment, Long> {
    @Query("SELECT te FROM TeacherEnrollment te WHERE te.teacher.role = 'TEACHER' AND te.teacher.id = :teacherId")
    List<TeacherEnrollment> findByTeacherId(@Param("teacherId") Long teacherId);

    @Transactional
    void deleteByTeacherIdAndCourseId(Long teacherId, Long courseId);
}
