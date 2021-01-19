package com.sandesh.security.service;

import com.sandesh.security.model.CustomUserDetails;
import com.sandesh.security.model.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersService usersService;

    public CustomUserDetailsService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = this.usersService.getUserByUsername(username);
        if (Objects.isNull(user)) throw new UsernameNotFoundException("Username not found");
        return new CustomUserDetails(user);
    }
}
