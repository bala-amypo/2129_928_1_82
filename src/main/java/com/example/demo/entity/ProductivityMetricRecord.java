package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "productivity_metrics",
    uniqueConstraints = @UniqueConstraint(columnNames = {"employee_id", "date"})
)
public class ProductivityMetricRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private EmployeeProfile employee;

    @NotNull
    private LocalDate date;

    @PositiveOrZero
    private Double hoursLogged;

    @PositiveOrZero
    private Integer tasksCompleted;

    @PositiveOrZero
    private Integer meetingsAttended;

    private Double productivityScore;
    private LocalDateTime submittedAt;

    @PrePersist
    void onCreate() {
        this.submittedAt = LocalDateTime.now();
    }

    public ProductivityMetricRecord() {}

    // getters & setters
    public Long getId() { return id; }

    public EmployeeProfile getEmployee() { return employee; }
    public void setEmployee(EmployeeProfile employee) { this.employee = employee; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Double getHoursLogged() { return hoursLogged; }
    public void setHoursLogged(Double hoursLogged) { this.hoursLogged = hoursLogged; }

    public Integer getTasksCompleted() { return tasksCompleted; }
    public void setTasksCompleted(Integer tasksCompleted) { this.tasksCompleted = tasksCompleted; }

    public Integer getMeetingsAttended() { return meetingsAttended; }
    public void setMeetingsAttended(Integer meetingsAttended) { this.meetingsAttended = meetingsAttended; }

    public Double getProductivityScore() { return productivityScore; }
    public void setProductivityScore(Double productivityScore) { this.productivityScore = productivityScore; }
}
