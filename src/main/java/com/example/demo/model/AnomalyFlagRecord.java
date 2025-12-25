package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "anomaly_flag_records")
public class AnomalyFlagRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔗 Employee relationship
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeProfile employee;

    // 🔗 Metric relationship (THIS FIXES THE ERROR)
    @ManyToOne
    @JoinColumn(name = "metric_id", nullable = false)
    private ProductivityMetricRecord metric;

    private String ruleCode;
    private String severity;

    @Column(length = 1000)
    private String details;

    private LocalDateTime flaggedAt;

    private Boolean resolved = false;

    @PrePersist
    public void onCreate() {
        this.flaggedAt = LocalDateTime.now();
    }

    // getters & setters
    public Long getId() { return id; }

    public EmployeeProfile getEmployee() { return employee; }
    public void setEmployee(EmployeeProfile employee) { this.employee = employee; }

    public ProductivityMetricRecord getMetric() { return metric; }
    public void setMetric(ProductivityMetricRecord metric) { this.metric = metric; }

    public String getRuleCode() { return ruleCode; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public LocalDateTime getFlaggedAt() { return flaggedAt; }

    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
}
