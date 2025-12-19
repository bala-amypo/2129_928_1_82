package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AnomalyFlagRecord {

    @Id
    private Long id;
    private boolean resolved;

    // Getter and setter for resolved
    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    // Other fields and getters/setters if required
}
