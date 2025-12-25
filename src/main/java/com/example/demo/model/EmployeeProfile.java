package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employee_profiles")
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String employeeId;

    @NotBlank
    private String fullName;

    @Email
    @Column(unique = true)
    private String email;

    private String teamName;

    private Boolean active = true;

    private String role;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<ProductivityMetricRecord> metrics;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // getters & setters
    public Long getId() { return id; }
    public String getEmployeeId() { return employeeId; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getTeamName() { return teamName; }
    public Boolean getActive() { return active; }
    public String getRole() { return role; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
    public void setActive(Boolean active) { this.active = active; }
    public void setRole(String role) { this.role = role; }
}
