package com.example.demo.service;

import com.example.demo.entity.AnomalyRule;
import java.util.List;

public interface AnomalyRuleService {
    AnomalyRule save(AnomalyRule rule);
    List<AnomalyRule> getAll();
}