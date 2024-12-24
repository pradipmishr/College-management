package com.pradip.College.management.Repository;

import com.pradip.College.management.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {



}
