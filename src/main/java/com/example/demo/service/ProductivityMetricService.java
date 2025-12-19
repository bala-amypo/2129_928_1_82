package com.example.demo.service;

import com.example.demo.entity.ProductivityMetricRecord;
import java.util.List;

public interface ProductivityMetricService {
    ProductivityMetricRecord save(ProductivityMetricRecord record);
    ProductivityMetricRecord getById(Long id);
    List<ProductivityMetricRecord> getAll();
}