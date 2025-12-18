package com.example.demo.Service;

import java.util.List;
import com.example.demo.Entity.ProductivityMetricRecord;

public interface ProductivityMetricService {

    ProductivityMetricRecord recordMetric(ProductivityMetricRecord metric);

    ProductivityMetricRecord updateMetric(Long id, ProductivityMetricRecord updated);

    List<ProductivityMetricRecord> getMetricsByEmployee(Long employeeId);

    ProductivityMetricRecord getMetricById(Long id);

    List<ProductivityMetricRecord> getAllMetrics();
}