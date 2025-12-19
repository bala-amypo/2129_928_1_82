package com.example.demo.repository;

import com.example.demo.entity.ProductivityMetricRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductivityMetricRepository
        extends JpaRepository<ProductivityMetricRecord, Long> {
}