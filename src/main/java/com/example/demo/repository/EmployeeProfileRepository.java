package com.example.demo.repository;

import java.util.Optional;
import com.example.demo.model.EmployeeProfile;

public interface EmployeeProfileRepository {
    Optional<EmployeeProfile> findByEmployeeId(String employeeId);
}
