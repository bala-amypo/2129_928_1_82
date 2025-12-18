// AnomalyRuleServiceImpl.java
package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.AnomalyRule;
import com.example.demo.repository.AnomalyRuleRepository;

@Service
public class AnomalyRuleServiceImpl implements AnomalyRuleService {

    private final AnomalyRuleRepository repo;

    public AnomalyRuleServiceImpl(AnomalyRuleRepository repo) {
        this.repo = repo;
    }

    public AnomalyRule createRule(AnomalyRule rule) {
        return repo.save(rule);
    }

    public AnomalyRule updateRule(Long id, AnomalyRule updatedRule) {
        AnomalyRule r = repo.findById(id).orElseThrow();
        r.setDescription(updatedRule.getDescription());
        r.setThresholdType(updatedRule.getThresholdType());
        r.setThresholdValue(updatedRule.getThresholdValue());
        r.setActive(updatedRule.isActive());
        return repo.save(r);
    }

    public List<AnomalyRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    public AnomalyRule getRuleByCode(String ruleCode) {
        return repo.findAll().stream()
                .filter(r -> r.getRuleCode().equals(ruleCode))
                .findFirst().orElseThrow();
    }

    public List<AnomalyRule> getAllRules() {
        return repo.findAll();
    }
}