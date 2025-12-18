package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class AnomalyRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ruleCode;

    private String description;
    private String thresholdType;
    private Double thresholdValue;
    private boolean active;

    public AnomalyRule() {}

    public AnomalyRule(Long id, String ruleCode, String description,String thresholdType, Double thresholdValue, boolean active) {
        this.id = id;
        this.ruleCode = ruleCode;
        this.description = description;
        this.thresholdType = thresholdType;
        this.thresholdValue = thresholdValue;
        this.active = active;
    }

    public Long getId() { 
     return id; 
    }
    public String getRuleCode() { 
     return ruleCode; 
    }
    public void setRuleCode(String ruleCode) { 
     this.ruleCode = ruleCode; 
    }
    public String getDescription() { 
     return description; 
    }
    public void setDescription(String description) { 
     this.description = description; 
    }
    public String getThresholdType() {
     return thresholdType; 
    }
    public void setThresholdType(String thresholdType) { 
     this.thresholdType = thresholdType; 
    }
    public Double getThresholdValue() { 
     return thresholdValue; 
    }
    public void setThresholdValue(Double thresholdValue) { 
     this.thresholdValue = thresholdValue; 
    }
    public boolean isActive() {
     return active; 
    }
    public void setActive(boolean active) { 
     this.active = active; 
    }
}