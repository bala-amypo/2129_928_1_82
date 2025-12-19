package com.example.demo.service.impl;

import com.example.demo.entity.ProductivityMetricRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductivityMetricRepository;
import com.example.demo.service.ProductivityMetricService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    private final ProductivityMetricRepository repo;

    public ProductivityMetricServiceImpl(ProductivityMetricRepository repo) {
        this.repo = repo;
    }

    public ProductivityMetricRecord save(ProductivityMetricRecord record) {
        record.setProductivityScore(
                (record.getHoursLogged() * 1.5) +
                (record.getTasksCompleted() * 2)
        );
        return repo.save(record);
    }

    public ProductivityMetricRecord getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Metric not found"));
    }

    public List<ProductivityMetricRecord> getAll() {
        return repo.findAll();
    }
}