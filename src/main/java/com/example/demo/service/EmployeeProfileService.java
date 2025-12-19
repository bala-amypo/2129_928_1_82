package com.example.demo.service;

import com.example.demo.entity.EmployeeProfile;
import java.util.List;

public interface EmployeeProfileService {
    EmployeeProfile save(EmployeeProfile emp);
    EmployeeProfile getById(Long id);
    List<EmployeeProfile> getAll();
}