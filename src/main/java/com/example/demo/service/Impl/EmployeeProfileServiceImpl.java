package com.example.demo.service.impl;

import com.example.demo.entity.EmployeeProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repo;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public EmployeeProfile save(EmployeeProfile emp) {
        return repo.save(emp);
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeProfile getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id: " + id)
                );
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeProfile> getAll() {
        return repo.findAll();
    }
}
