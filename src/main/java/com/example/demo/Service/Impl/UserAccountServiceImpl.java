package com.example.demo.Service;

import org.springframework.stereotype.Service;
import com.example.demo.Entity.UserAccount;
import com.example.demo.Repository.UserAccountRepository;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    public UserAccount registerUser(UserAccount user) {
        return repo.save(user);
    }

    public UserAccount findByEmail(String email) {
        return repo.findByEmail(email).orElseThrow();
    }
}