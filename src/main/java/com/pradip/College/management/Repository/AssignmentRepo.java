package com.pradip.College.management.Repository;

import com.pradip.College.management.Model.Assignment;
import com.pradip.College.management.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepo extends JpaRepository<Assignment, Long> {
    List<Assignment> findByCourseIn(List<Course> courses);
}
