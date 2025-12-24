package com.example.demo.service.impl;

import com.example.demo.entity.TeamSummaryRecord;
import com.example.demo.repository.TeamSummaryRepository;
import com.example.demo.service.TeamSummaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamSummaryServiceImpl implements TeamSummaryService {

    private final TeamSummaryRepository repo;

    public TeamSummaryServiceImpl(TeamSummaryRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public TeamSummaryRecord save(TeamSummaryRecord summary) {
        return repo.save(summary);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TeamSummaryRecord> getAll() {
        return repo.findAll();
    }
}
