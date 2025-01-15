package com.pradip.College.management.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.pradip.College.management.Model.Users.*;

import java.util.*;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {
    private Users user;
    private String username;
    private String password;
    private Set<Role> roles;

    public UserPrincipal(Users user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roles = user.getRoles(); // Get roles from the User entity
    }


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        Arrays.stream(Role.values())
//                .forEach(role -> authorities.add(new SimpleGrantedAuthority(role.name())));
//
//        return authorities;
//    }
//@Override
//public Collection<? extends GrantedAuthority> getAuthorities() {
//    List<GrantedAuthority> authorities = new ArrayList<>();
//
//    for (Role role : user.getRole()) {
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName())); // Dynamically add prefix
//    }
//
//    return authorities;
//}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + roles.name())) // Add the "ROLE_" prefix dynamically
                .collect(Collectors.toList());
    }



    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Assuming account never expires
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Assuming account never gets locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Assuming credentials never expire
    }

    @Override
    public boolean isEnabled() {
        return true; // Assuming account is always enabled
    }
}
