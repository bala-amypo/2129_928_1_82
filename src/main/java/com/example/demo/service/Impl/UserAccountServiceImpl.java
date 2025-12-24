package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    /**
     * WRITE operation → Transaction REQUIRED
     * Business validation is done here
     */
    @Override
    @Transactional
    public UserAccount save(UserAccount user) {

        // ✅ Business validation (NOT annotation-based)
        if (user.getPassword() == null || user.getPassword().length() < 6) {
            throw new IllegalArgumentException(
                    "Password Should be greater than 6 characters"
            );
        }

        return repo.save(user);
    }

    /**
     * READ operation → Transaction NOT REQUIRED
     */
    @Override
    public List<UserAccount> getAll() {
        return repo.findAll();
    }

    /**
     * READ operation → Transaction NOT REQUIRED
     */
    @Override
    public UserAccount getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id
                        )
                );
    }
}
