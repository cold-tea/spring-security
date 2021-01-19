package com.sandesh.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String home() {
        return "Home string";
    }

    @GetMapping("/secured")
    public String secured() {
        return "This is the secured endpoint";
    }

    @GetMapping("/adminSecured")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminSecured() {
        return "This is the admin secured endpoint";
    }
}
