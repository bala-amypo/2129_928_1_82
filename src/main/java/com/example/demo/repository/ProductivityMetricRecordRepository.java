package com.example.demo.repository;

import java.util.List;
import com.example.demo.model.ProductivityMetricRecord;

public interface ProductivityMetricRecordRepository {
    List<ProductivityMetricRecord> findByEmployeeId(Long employeeId);
}
