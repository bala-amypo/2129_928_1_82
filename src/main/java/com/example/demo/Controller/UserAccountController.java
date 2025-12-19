package com.example.demo.Controller;

import com.example.demo.Entity.UserAccount;
import com.example.demo.Service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    // Create a new user
    @PostMapping
    public UserAccount createUser(@RequestBody UserAccount userAccount) {
        return userAccountService.createUser(userAccount);
    }

    // Get all users
    @GetMapping
    public List<UserAccount> getAllUsers() {
        return userAccountService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public Optional<UserAccount> getUserById(@PathVariable Long id) {
        return userAccountService.getUserById(id);
    }

    // Update user
    @PutMapping("/{id}")
    public UserAccount updateUser(@PathVariable Long id, @RequestBody UserAccount userAccount) {
        return userAccountService.updateUser(id, userAccount);
    }

    // Delete user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userAccountService.deleteUser(id);
    }
}
