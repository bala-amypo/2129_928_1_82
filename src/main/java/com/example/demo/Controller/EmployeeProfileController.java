package com.example.demo.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entity.EmployeeProfile;
import com.example.demo.Service.EmployeeProfileService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeProfileController {

    private final EmployeeProfileService service;

    public EmployeeProfileController(EmployeeProfileService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeProfile create(@RequestBody EmployeeProfile e) {
        return service.createEmployee(e);
    }

    @GetMapping
    public List<EmployeeProfile> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeProfile getById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}/status")
    public EmployeeProfile updateStatus(@PathVariable Long id,@RequestParam boolean active) {
        return service.updateEmployeeStatus(id, active);
    }

    @GetMapping("/lookup/{employeeId}")
    public EmployeeProfile lookup(@PathVariable String employeeId) {
        return service.findByEmployeeId(employeeId);
    }
}