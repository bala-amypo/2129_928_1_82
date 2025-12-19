package com.example.demo.Service;

import com.example.demo.Entity.UserAccount;
import com.example.demo.Repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountService {

    @Autowired
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
