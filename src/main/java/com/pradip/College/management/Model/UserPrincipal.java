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
        this.user=user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Convert roles to a collection of GrantedAuthority
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                .collect(Collectors.toSet());
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
