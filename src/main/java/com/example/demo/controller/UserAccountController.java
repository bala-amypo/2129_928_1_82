package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.UserAccount;
import com.example.demo.Service.UserAccountService;

@RestController
@RequestMapping("/api/user-accounts")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping
    public UserAccount createUser(@RequestBody UserAccount user) {
        return service.registerUser(user);
    }

    @GetMapping
    public List<UserAccount> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserAccount getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @GetMapping("/email/{email}")
    public UserAccount getUserByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }
}