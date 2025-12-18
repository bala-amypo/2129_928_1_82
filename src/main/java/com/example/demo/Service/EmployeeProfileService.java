package com.example.demo.Service;

import java.util.List;
import com.example.demo.Entity.EmployeeProfile;

public interface EmployeeProfileService {

    EmployeeProfile createEmployee(EmployeeProfile employee);

    EmployeeProfile getEmployeeById(Long id);

    List<EmployeeProfile> getAllEmployees();

    EmployeeProfile findByEmployeeId(String employeeId);

    EmployeeProfile updateEmployeeStatus(Long id, boolean active);
}