package com.example.demo.Service;

import java.util.List;
import com.example.demo.Entity.AnomalyRule;

public interface AnomalyRuleService {

    AnomalyRule createRule(AnomalyRule rule);

    AnomalyRule updateRule(Long id, AnomalyRule updatedRule);

    List<AnomalyRule> getActiveRules();

    AnomalyRule getRuleByCode(String ruleCode);

    List<AnomalyRule> getAllRules();
}