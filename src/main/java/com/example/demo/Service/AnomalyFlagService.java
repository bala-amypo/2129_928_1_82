package com.example.demo.Service;

import java.util.List;
import com.example.demo.Entity.AnomalyFlagRecord;

public interface AnomalyFlagService {

    AnomalyFlagRecord flagAnomaly(AnomalyFlagRecord flag);

    AnomalyFlagRecord resolveFlag(Long id);

    List<AnomalyFlagRecord> getFlagsByEmployee(Long employeeId);

    List<AnomalyFlagRecord> getFlagsByMetric(Long metricId);

    List<AnomalyFlagRecord> getAllFlags();
}