package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;

    // getters & setters
    public Set<String> getRoles() { return roles; }
    public void setRoles(Set<String> roles) { this.roles = roles; }
}
