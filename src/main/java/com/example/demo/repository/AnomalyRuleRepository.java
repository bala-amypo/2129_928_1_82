package com.example.demo.repository;

import com.example.demo.entity.AnomalyRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnomalyRuleRepository extends JpaRepository<AnomalyRule, Long> {
}