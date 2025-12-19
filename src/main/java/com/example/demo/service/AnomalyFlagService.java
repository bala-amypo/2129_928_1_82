package com.example.demo.service;

import com.example.demo.entity.AnomalyFlagRecord;
import java.util.List;

public interface AnomalyFlagService {
    AnomalyFlagRecord save(AnomalyFlagRecord flag);
    List<AnomalyFlagRecord> getAll();
}