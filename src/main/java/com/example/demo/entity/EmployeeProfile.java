package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
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
    private String role;
    private Boolean active;
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.active = true;
    }

    public EmployeeProfile() {}

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
    public Boolean getActive() {
         return active; 
    }
    public void setActive(Boolean active) {
         this.active = active; 
    }
}