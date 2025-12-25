package com.example.demo.repository;

import java.util.List;
import com.example.demo.model.AnomalyRule;

public interface AnomalyRuleRepository {
    List<AnomalyRule> findByActiveTrue();
}
