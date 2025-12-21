package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "anomaly_flags")
public class AnomalyFlagRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id")
    private EmployeeProfile employee;

    @ManyToOne(optional = false)
    @JoinColumn(name = "metric_id")
    private ProductivityMetricRecord metric;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rule_id")
    private AnomalyRule rule;

    private Boolean resolved;
    private LocalDateTime flaggedAt;

    @PrePersist
    void onCreate() {
        this.flaggedAt = LocalDateTime.now();
        this.resolved = false;
    }

    public AnomalyFlagRecord() {}

    public Long getId() {
        return id;
    }

    public EmployeeProfile getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeProfile employee) {
        this.employee = employee;
    }

    public ProductivityMetricRecord getMetric() {
        return metric;
    }

    public void setMetric(ProductivityMetricRecord metric) {
        this.metric = metric;
    }

    public AnomalyRule getRule() {
        return rule;
    }

    public void setRule(AnomalyRule rule) {
        this.rule = rule;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }

    public LocalDateTime getFlaggedAt() {
        return flaggedAt;
    }
}
