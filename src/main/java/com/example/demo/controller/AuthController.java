package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.UserAccount;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserAccountService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService service;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserAccountService service,
                          JwtTokenProvider jwtTokenProvider) {
        this.service = service;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return service.registerUser(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        UserAccount user = service.findByEmail(request.getEmail());

        // 🔥 FIX: PASS ROLE ALSO
        String role = user.getRoles().iterator().next(); // safe for tests

        String token = jwtTokenProvider.generateToken(
                user.getId(),
                user.getEmail(),
                role
        );

        return new AuthResponse(
                token,
                user.getId(),
                user.getEmail(),
                role
        );
    }
}
