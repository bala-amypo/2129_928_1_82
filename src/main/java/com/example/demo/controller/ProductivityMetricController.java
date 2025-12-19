package com.example.demo.controller;

import com.example.demo.entity.ProductivityMetricRecord;
import com.example.demo.service.ProductivityMetricService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metrics")
public class ProductivityMetricController {

    private final ProductivityMetricService service;

    public ProductivityMetricController(ProductivityMetricService service) {
        this.service = service;
    }

    @PostMapping
    public ProductivityMetricRecord create(@Valid @RequestBody ProductivityMetricRecord r) {
        return service.save(r);
    }

    @GetMapping("/{id}")
    public ProductivityMetricRecord get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ProductivityMetricRecord> getAll() {
        return service.getAll();
    }
}