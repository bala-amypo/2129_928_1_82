package com.example.demo.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;
    private String role;
    private LocalDateTime createdAt;

    public UserAccount() {}

    public UserAccount(Long id, String email, String password,String role, LocalDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { 
     return id; 
    }

    public String getEmail() { 
     return email; 
    }
    public void setEmail(String email) {
     this.email = email; 
    }

    public String getPassword() {
     return password; 
    }
    public void setPassword(String password) {
     this.password = password; 
    }

    public String getRole() {
     return role; 
    }
    public void setRole(String role) {
     this.role = role; 
    }

    public LocalDateTime getCreatedAt() {
     return createdAt; 
    }
}