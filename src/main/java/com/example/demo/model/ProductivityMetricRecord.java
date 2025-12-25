package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
    name = "productivity_metric_records",
    uniqueConstraints = @UniqueConstraint(columnNames = {"employee_id", "date"})
)
public class ProductivityMetricRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeProfile employee;

    private LocalDate date;

    private Double hoursLogged;
    private Integer tasksCompleted;
    private Integer meetingsAttended;
    private Double productivityScore;

    @Column(columnDefinition = "TEXT")
    private String rawDataJson;

    private LocalDateTime submittedAt;

    @OneToMany(mappedBy = "metric", cascade = CascadeType.ALL)
    private List<AnomalyFlagRecord> anomalyFlags;

    @PrePersist
    public void onSubmit() {
        submittedAt = LocalDateTime.now();
    }

    // getters & setters
    public Long getId() { return id; }
    public EmployeeProfile getEmployee() { return employee; }
    public Double getHoursLogged() { return hoursLogged; }
    public Integer getTasksCompleted() { return tasksCompleted; }
    public Integer getMeetingsAttended() { return meetingsAttended; }
    public Double getProductivityScore() { return productivityScore; }
    public String getRawDataJson() { return rawDataJson; }

    public void setEmployee(EmployeeProfile employee) { this.employee = employee; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setHoursLogged(Double hoursLogged) { this.hoursLogged = hoursLogged; }
    public void setTasksCompleted(Integer tasksCompleted) { this.tasksCompleted = tasksCompleted; }
    public void setMeetingsAttended(Integer meetingsAttended) { this.meetingsAttended = meetingsAttended; }
    public void setProductivityScore(Double productivityScore) { this.productivityScore = productivityScore; }
    public void setRawDataJson(String rawDataJson) { this.rawDataJson = rawDataJson; }
}
