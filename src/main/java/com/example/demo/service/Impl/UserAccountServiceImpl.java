package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
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

    @Override
    @Transactional
    public UserAccount save(UserAccount user) {
        return repo.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserAccount> getAll() {
        return repo.findAll();
    }
}
