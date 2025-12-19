package com.example.demo.controller;

import com.example.demo.entity.AnomalyRule;
import com.example.demo.service.AnomalyRuleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class AnomalyRuleController {

    private final AnomalyRuleService service;

    public AnomalyRuleController(AnomalyRuleService service) {
        this.service = service;
    }

    @PostMapping
    public AnomalyRule create(@Valid @RequestBody AnomalyRule rule) {
        return service.save(rule);
    }

    @GetMapping
    public List<AnomalyRule> getAll() {
        return service.getAll();
    }
}