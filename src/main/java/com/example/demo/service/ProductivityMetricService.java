package com.example.demo.service;

import com.example.demo.model.ProductivityMetricRecord;
import java.util.*;

public interface ProductivityMetricService {
    ProductivityMetricRecord recordMetric(ProductivityMetricRecord r);
    Optional<ProductivityMetricRecord> getMetricById(Long id);
    List<ProductivityMetricRecord> getAllMetrics();
}
