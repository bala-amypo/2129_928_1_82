package com.example.demo.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class TeamSummaryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;
    private LocalDate summaryDate;
    private Double avgHoursLogged;
    private Double avgTasksCompleted;
    private Double avgScore;
    private Integer anomalyCount;
    private LocalDateTime generatedAt;

    public TeamSummaryRecord() {}

    public TeamSummaryRecord(Long id, String teamName, LocalDate summaryDate,Double avgHoursLogged, Double avgTasksCompleted,Double avgScore, Integer anomalyCount,LocalDateTime generatedAt) {
        this.id = id;
        this.teamName = teamName;
        this.summaryDate = summaryDate;
        this.avgHoursLogged = avgHoursLogged;
        this.avgTasksCompleted = avgTasksCompleted;
        this.avgScore = avgScore;
        this.anomalyCount = anomalyCount;
        this.generatedAt = generatedAt;
    }

    @PrePersist
    public void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }

    public Long getId() { 
     return id; 
    }
    public String getTeamName() {
     return teamName; 
    }
    public void setTeamName(String teamName) {
     this.teamName = teamName; 
    }
    public LocalDate getSummaryDate() { 
     return summaryDate; 
    }
    public void setSummaryDate(LocalDate summaryDate) {
     this.summaryDate = summaryDate; 
    }
    public Double getAvgHoursLogged() {
     return avgHoursLogged; 
    }
    public void setAvgHoursLogged(Double avgHoursLogged) {
     this.avgHoursLogged = avgHoursLogged; 
    }
    public Double getAvgTasksCompleted() {
     return avgTasksCompleted; 
    }
    public void setAvgTasksCompleted(Double avgTasksCompleted) {
     this.avgTasksCompleted = avgTasksCompleted; 
    }
    public Double getAvgScore() {
     return avgScore; 
    }
    public void setAvgScore(Double avgScore) {
     this.avgScore = avgScore; 
    }
    public Integer getAnomalyCount() {
     return anomalyCount; 
    }
    public void setAnomalyCount(Integer anomalyCount) {
     this.anomalyCount = anomalyCount; 
    }
}