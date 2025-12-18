package com.example.demo.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.AnomalyFlagRecord;
import com.example.demo.Repository.AnomalyFlagRecordRepository;

@Service
public class AnomalyFlagServiceImpl implements AnomalyFlagService {

    private final AnomalyFlagRecordRepository repo;

    public AnomalyFlagServiceImpl(AnomalyFlagRecordRepository repo) {
        this.repo = repo;
    }

    public AnomalyFlagRecord flagAnomaly(AnomalyFlagRecord flag) {
        return repo.save(flag);
    }

    public AnomalyFlagRecord resolveFlag(Long id) {
        AnomalyFlagRecord f = repo.findById(id).orElseThrow();
        f.setResolved(true);
        return repo.save(f);
    }

    public List<AnomalyFlagRecord> getFlagsByEmployee(Long employeeId) {
        return repo.findAll().stream().filter(f -> f.getEmployeeId().equals(employeeId)).toList();
    }

    public List<AnomalyFlagRecord> getFlagsByMetric(Long metricId) {
        return repo.findByMetricId(metricId);
    }

    public List<AnomalyFlagRecord> getAllFlags() {
        return repo.findAll();
    }
}