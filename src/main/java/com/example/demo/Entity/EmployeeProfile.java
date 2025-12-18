// EmployeeProfile.java
package com.example.demo.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String employeeId;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String teamName;
    private String role;
    private boolean active;
    private LocalDateTime createdAt;

    public EmployeeProfile() {}

    public EmployeeProfile(Long id, String employeeId, String fullName,String email, String teamName, String role,boolean active, LocalDateTime createdAt) {
        this.id = id;
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.email = email;
        this.teamName = teamName;
        this.role = role;
        this.active = active;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.active = true;
    }

    public Long getId() {
         return id; 
    }
    public String getEmployeeId() {
         return employeeId; 
    }
    public void setEmployeeId(String employeeId) { 
        this.employeeId = employeeId; 
    }
    public String getFullName() { 
        return fullName; 
    }
    public void setFullName(String fullName) { 
        this.fullName = fullName; 
    }
    public String getEmail() { 
    return email; 
    }
    public void setEmail(String email) { 
        this.email = email; 
    }
    public String getTeamName() {
         return teamName; 
    }
    public void setTeamName(String teamName) {
         this.teamName = teamName; 
    }
    public String getRole() { 
        return role; 
    }
    public void setRole(String role) {
         this.role = role; 
    }
    public boolean isActive() { 
        return active; 
    }
    public void setActive(boolean active) { 
        this.active = active; 
    }
    public LocalDateTime getCreatedAt() { 
        return createdAt; 
    }
}