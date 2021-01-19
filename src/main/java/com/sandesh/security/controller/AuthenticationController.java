package com.sandesh.security.controller;

import com.sandesh.security.filter.JwtUtil;
import com.sandesh.security.model.AuthenticationRequest;
import com.sandesh.security.service.CustomUserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationController(JwtUtil jwtUtil, CustomUserDetailsService customUserDetailsService, AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.customUserDetailsService = customUserDetailsService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String > authenticate(@RequestBody AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException ex) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(request.getUsername());
        return ResponseEntity.ok(jwtUtil.generateToken(userDetails));
    }
}
