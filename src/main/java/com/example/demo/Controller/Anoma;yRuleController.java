package com.example.demo.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entity.AnomalyRule;
import com.example.demo.Service.AnomalyRuleService;

@RestController
@RequestMapping("/api/anomaly-rules")
public class AnomalyRuleController {

    private final AnomalyRuleService service;

    public AnomalyRuleController(AnomalyRuleService service) {
        this.service = service;
    }

    @PostMapping
    public AnomalyRule create(@RequestBody AnomalyRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public AnomalyRule update(@PathVariable Long id,@RequestBody AnomalyRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<AnomalyRule> active() {
        return service.getActiveRules();
    }

    @GetMapping
    public List<AnomalyRule> all() {
        return service.getAllRules();
    }
}