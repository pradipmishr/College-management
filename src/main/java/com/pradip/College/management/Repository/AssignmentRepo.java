package com.pradip.College.management.Repository;

import com.pradip.College.management.Model.Assignment;
import com.pradip.College.management.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface AssignmentRepo extends JpaRepository<Assignment, Long> {
   // List<Assignment> findByCourseIn(List<Course> courses);

    @Query("SELECT a FROM Assignment a WHERE a.course IN :courses")
    List<Assignment> findByCourseIn(@Param("courses") List<Course> courses);




    List<Assignment> findByCourse(Course course);
}
