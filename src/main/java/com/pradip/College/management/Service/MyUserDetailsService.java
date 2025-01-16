package com.pradip.College.management.Service;

import com.pradip.College.management.Model.UserPrincipal;
import com.pradip.College.management.Model.Users;
import com.pradip.College.management.Repository.UsersRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private UsersRepo usersRepo;
    public MyUserDetailsService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user= usersRepo.findByUsername(username);

        if (user==null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        System.out.println("User found: " + user);
        return new UserPrincipal(user);
    }

}

