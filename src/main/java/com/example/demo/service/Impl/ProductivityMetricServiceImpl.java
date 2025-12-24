package com.example.demo.service.impl;

import com.example.demo.entity.ProductivityMetricRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductivityMetricRepository;
import com.example.demo.service.ProductivityMetricService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    private final ProductivityMetricRepository repo;

    public ProductivityMetricServiceImpl(ProductivityMetricRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public ProductivityMetricRecord save(ProductivityMetricRecord record) {

        double score =
                (record.getHoursLogged() != null ? record.getHoursLogged() * 1.5 : 0) +
                (record.getTasksCompleted() != null ? record.getTasksCompleted() * 2 : 0);

        record.setProductivityScore(score);

        return repo.save(record);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductivityMetricRecord getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Metric not found with id: " + id)
                );
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductivityMetricRecord> getAll() {
        return repo.findAll();
    }
}
