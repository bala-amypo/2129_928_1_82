package com.example.demo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.AnomalyRule;

public interface AnomalyRuleRepository extends JpaRepository<AnomalyRule, Long> {

    List<AnomalyRule> findByActiveTrue();
}