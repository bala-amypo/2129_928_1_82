package com.example.demo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.ProductivityMetricRecord;

public interface ProductivityMetricRecordRepository extends JpaRepository<ProductivityMetricRecord, Long> {

    List<ProductivityMetricRecord> findByEmployeeId(Long employeeId);
}