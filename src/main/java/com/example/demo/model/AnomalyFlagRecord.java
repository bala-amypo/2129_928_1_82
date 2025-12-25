package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "anomaly_flag_records")
public class AnomalyFlagRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private String severity;
    private String details;
    private Boolean resolved = false;

    private LocalDateTime flaggedAt;

    @ManyToOne
    @JoinColumn(name = "metric_id")
    private ProductivityMetricRecord metric;

    @PrePersist
    public void onFlag() {
        flaggedAt = LocalDateTime.now();
    }

    // getters & setters
    public Long getId() { return id; }
    public String getRuleCode() { return ruleCode; }
    public Boolean getResolved() { return resolved; }

    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }
    public void setSeverity(String severity) { this.severity = severity; }
    public void setDetails(String details) { this.details = details; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
    public void setMetric(ProductivityMetricRecord metric) { this.metric = metric; }
}
