package com.example.demo.controller;

import com.example.demo.entity.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeProfileController {

    private final EmployeeProfileService service;

    public EmployeeProfileController(EmployeeProfileService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeProfile create(@Valid @RequestBody EmployeeProfile emp) {
        return service.save(emp);
    }

    @GetMapping("/{id}")
    public EmployeeProfile get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<EmployeeProfile> getAll() {
        return service.getAll();
    }
}