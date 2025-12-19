package com.example.demo.repository;

import com.example.demo.entity.AnomalyFlagRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnomalyFlagRepository
        extends JpaRepository<AnomalyFlagRecord, Long> {
}