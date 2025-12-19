package com.example.demo.Service;

import com.example.demo.Entity.UserAccount;
import com.example.demo.Repository.UserAccountRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserAccountService {

    @Inject
    private UserAccountRepository userAccountRepository;

    // Create operation
    public UserAccount createUser(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    // Get all users
    public List<UserAccount> getAllUsers() {
        return userAccountRepository.findAll();
    }

    // Get user by ID
    public Optional<UserAccount> getUserById(Long id) {
        return userAccountRepository.findById(id);
    }

    // Update user
    public UserAccount updateUser(Long id, UserAccount userAccount) {
        userAccount.setId(id); // Ensure the ID is set for the update
        return userAccountRepository.save(userAccount);
    }

    // Delete user
    public void deleteUser(Long id) {
        userAccountRepository.deleteById(id);
    }
}
