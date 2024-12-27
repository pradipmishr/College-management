package com.pradip.College.management.Repository;

import com.pradip.College.management.Model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepo extends JpaRepository<Submission,Long> {
}
