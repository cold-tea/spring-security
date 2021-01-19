package com.sandesh.security.service;

import com.sandesh.security.model.Users;
import com.sandesh.security.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository repository;

    public UsersService(UsersRepository repository) {
        this.repository = repository;
    }

    public Users getUserByUsername(String username) {
        return this.repository.findByUsername(username);
    }
}
