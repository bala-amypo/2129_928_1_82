package com.example.demo.repository;

import java.util.List;
import com.example.demo.model.AnomalyFlagRecord;

public interface AnomalyFlagRecordRepository {
    List<AnomalyFlagRecord> findByMetricId(Long metricId);
    List<AnomalyFlagRecord> findAll();
}
