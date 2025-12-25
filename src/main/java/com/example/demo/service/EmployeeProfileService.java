package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;
import java.util.Optional;

public interface EmployeeProfileService {
    EmployeeProfile createEmployee(EmployeeProfile e);
    EmployeeProfile getEmployeeById(Long id);
    EmployeeProfile updateEmployeeStatus(Long id, boolean active);
    Optional<EmployeeProfile> findByEmployeeId(String empId);
}
