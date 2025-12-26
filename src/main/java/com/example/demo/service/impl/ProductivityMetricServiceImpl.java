package com.example.demo.service.impl;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.repository.ProductivityMetricRecordRepository;
import com.example.demo.service.ProductivityMetricService;
import com.example.demo.util.ProductivityCalculator;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    private final ProductivityMetricRecordRepository repository;

    public ProductivityMetricServiceImpl(ProductivityMetricRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductivityMetricRecord recordMetric(ProductivityMetricRecord metric) {

        if (metric.getEmployeeId() == null || metric.getDate() == null) {
            throw new IllegalArgumentException("Invalid metric");
        }

        // uniqueness check (employeeId + date)
        List<ProductivityMetricRecord> existing =
                repository.findByEmployeeId(metric.getEmployeeId());

        boolean duplicate = existing.stream()
                .anyMatch(m -> metric.getDate().equals(m.getDate()));

        if (duplicate) {
            throw new IllegalStateException("Metric already exists for this employee and date");
        }

        double score = ProductivityCalculator.computeScore(
                metric.getHoursLogged(),
                metric.getTasksCompleted(),
                metric.getMeetingsAttended()
        );

        metric.setProductivityScore(score);
        return repository.save(metric);
    }

    @Override
    public ProductivityMetricRecord updateMetric(Long id, ProductivityMetricRecord updated) {
        ProductivityMetricRecord existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Metric not found"));

        existing.setHoursLogged(updated.getHoursLogged());
        existing.setTasksCompleted(updated.getTasksCompleted());
        existing.setMeetingsAttended(updated.getMeetingsAttended());

        double score = ProductivityCalculator.computeScore(
                updated.getHoursLogged(),
                updated.getTasksCompleted(),
                updated.getMeetingsAttended()
        );

        existing.setProductivityScore(score);
        return repository.save(existing);
    }

    @Override
    public Optional<ProductivityMetricRecord> getMetricById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<ProductivityMetricRecord> getMetricsByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public List<ProductivityMetricRecord> getAllMetrics() {
        return repository.findAll();
    }
}
