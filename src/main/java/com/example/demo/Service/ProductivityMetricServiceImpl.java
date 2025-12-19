package com.example.demo.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.ProductivityMetricRecord;
import com.example.demo.Repository.ProductivityMetricRecordRepository;


@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    private final ProductivityMetricRecordRepository repo;

    public ProductivityMetricServiceImpl(ProductivityMetricRecordRepository repo) {
        this.repo = repo;
    }

    public ProductivityMetricRecord recordMetric(ProductivityMetricRecord m) {
        double score = ProductivityCalculator.computeScore(m.getHoursLogged(),m.getTasksCompleted(),m.getMeetingsAttended());
        m.setProductivityScore(score);
        return repo.save(m);
    }

    public ProductivityMetricRecord updateMetric(Long id, ProductivityMetricRecord updated) {
        ProductivityMetricRecord m = repo.findById(id).orElseThrow();
        m.setHoursLogged(updated.getHoursLogged());
        m.setTasksCompleted(updated.getTasksCompleted());
        m.setMeetingsAttended(updated.getMeetingsAttended());
        return recordMetric(m);
    }

    public List<ProductivityMetricRecord> getMetricsByEmployee(Long employeeId) {
        return repo.findByEmployeeId(employeeId);
    }

    public ProductivityMetricRecord getMetricById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<ProductivityMetricRecord> getAllMetrics() {
        return repo.findAll();
    }
    

    public class ProductivityCalculator {

    
        public double calculateProductivity(int someInput) {
            return someInput * 1.5; // Placeholder logic
    }
}

}