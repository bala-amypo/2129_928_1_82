// AnomalyFlagServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.AnomalyFlagRecord;
import com.example.demo.repository.AnomalyFlagRepository;
import com.example.demo.service.AnomalyFlagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnomalyFlagServiceImpl implements AnomalyFlagService {

    private final AnomalyFlagRepository repo;

    public AnomalyFlagServiceImpl(AnomalyFlagRepository repo) {
        this.repo = repo;
    }

    public AnomalyFlagRecord save(AnomalyFlagRecord flag) {
        return repo.save(flag);
    }

    public List<AnomalyFlagRecord> getAll() {
        return repo.findAll();
    }
}