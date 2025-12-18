package com.example.demo.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class AnomalyFlagRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private Long metricId;
    private String ruleCode;
    private String severity;
    private String details;
    private boolean resolved;
    private LocalDateTime flaggedAt;

    public AnomalyFlagRecord() {}

    public AnomalyFlagRecord(Long id, Long employeeId, Long metricId,
                             String ruleCode, String severity,
                             String details, boolean resolved,
                             LocalDateTime flaggedAt) {
        this.id = id;
        this.employeeId = employeeId;
        this.metricId = metricId;
        this.ruleCode = ruleCode;
        this.severity = severity;
        this.details = details;
        this.resolved = resolved;
        this.flaggedAt = flaggedAt;
    }

    @PrePersist
    public void onCreate() {
        this.flaggedAt = LocalDateTime.now();
        this.resolved = false;
    }

    public Long getId() { 
     return id; 
    }
    public Long getEmployeeId() { 
     return employeeId; 
    }
    public void setEmployeeId(Long employeeId) { 
     this.employeeId = employeeId; 
    }
    public Long getMetricId() { 
     return metricId; 
    }
    public void setMetricId(Long metricId) { 
     this.metricId = metricId; 
    }
    public String getRuleCode() { 
     return ruleCode; 
    }
    public void setRuleCode(String ruleCode) { 
     this.ruleCode = ruleCode; 
    }
    public String getSeverity() { 
     return severity; 
    }
    public void setSeverity(String severity) { 
     this.severity = severity; 
    }
    public String getDetails() { 
     return details; 
    }
    public void setDetails(String details) { 
     this.details = details; 
    }
    public boolean isResolved() {
     return resolved; 
    }
}