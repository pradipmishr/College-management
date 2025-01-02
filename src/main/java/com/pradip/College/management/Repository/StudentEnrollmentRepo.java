package com.pradip.College.management.Repository;

import com.pradip.College.management.Model.Course;
import com.pradip.College.management.Model.StudentEnrollment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentEnrollmentRepo extends JpaRepository<StudentEnrollment,Long> {

    @Query("SELECT se FROM StudentEnrollment se WHERE se.student.role = 'STUDENT' AND se.student.id = :studentId")
    List<StudentEnrollment> findByStudentId(@Param("studentId") Long studentId);
    @Transactional
    void deleteByStudentIdAndCourseId(Long sid, Long cid);

   // List<Course> findCoursesByStudentId(Long studentId);

    @Query("SELECT e.course FROM StudentEnrollment e WHERE e.student.id = :studentId")
    List<Course> findCoursesByStudentId(@Param("studentId") Long studentId);


//    @Query("SELECT se FROM StudentEnrollment se WHERE se.student.id = :studentId")
//    List<StudentEnrollment> findEnrollmentsByStudentId(@Param("studentId") Long studentId);

}
