package com.example.demo.service.impl;

import com.example.demo.entity.AnomalyRule;
import com.example.demo.repository.AnomalyRuleRepository;
import com.example.demo.service.AnomalyRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnomalyRuleServiceImpl implements AnomalyRuleService {

    private final AnomalyRuleRepository repo;

    public AnomalyRuleServiceImpl(AnomalyRuleRepository repo) {
        this.repo = repo;
    }

    public AnomalyRule save(AnomalyRule rule) {
        return repo.save(rule);
    }

    public List<AnomalyRule> getAll() {
        return repo.findAll();
    }
}