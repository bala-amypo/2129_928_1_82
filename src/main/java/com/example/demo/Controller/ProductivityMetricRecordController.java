package com.example.demo.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entity.ProductivityMetricRecord;
import com.example.demo.Service.ProductivityMetricService;

@RestController
@RequestMapping("/api/metrics")
public class ProductivityMetricRecordController {

    private final ProductivityMetricService service;

    public ProductivityMetricRecordController(ProductivityMetricService service) {
        this.service = service;
    }

    @PostMapping
    public ProductivityMetricRecord record(@RequestBody ProductivityMetricRecord m) {
        return service.recordMetric(m);
    }

    @PutMapping("/{id}")
    public ProductivityMetricRecord update(@PathVariable Long id,@RequestBody ProductivityMetricRecord m) {
        return service.updateMetric(id, m);
    }

    @GetMapping("/employee/{employeeId}")
    public List<ProductivityMetricRecord> byEmployee(@PathVariable Long employeeId) {
        return service.getMetricsByEmployee(employeeId);
    }

    @GetMapping("/{id}")
    public ProductivityMetricRecord get(@PathVariable Long id) {
        return service.getMetricById(id);
    }

    @GetMapping
    public List<ProductivityMetricRecord> all() {
        return service.getAllMetrics();
    }
}