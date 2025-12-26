package com.example.demo.service;

import com.example.demo.model.AnomalyFlagRecord;

import java.util.List;

public interface AnomalyFlagService {

    AnomalyFlagRecord flagAnomaly(AnomalyFlagRecord flag);

    AnomalyFlagRecord resolveFlag(Long id);

    List<AnomalyFlagRecord> getAllFlags();

    List<AnomalyFlagRecord> getFlagsByMetric(Long metricId);
}
