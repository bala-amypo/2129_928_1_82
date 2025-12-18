//EmployeeProfileServiceImpl.java
package com.example.demo.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.EmployeeProfile;
import com.example.demo.Repository.EmployeeProfileRepository;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repo;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository repo) {
        this.repo = repo;
    }

    public EmployeeProfile createEmployee(EmployeeProfile employee) {
        return repo.save(employee);
    }

    public EmployeeProfile getEmployeeById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<EmployeeProfile> getAllEmployees() {
        return repo.findAll();
    }

    public EmployeeProfile findByEmployeeId(String employeeId) {
        return repo.findByEmployeeId(employeeId).orElseThrow();
    }

    public EmployeeProfile updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile emp = getEmployeeById(id);
        emp.setActive(active);
        return repo.save(emp);
    }
}