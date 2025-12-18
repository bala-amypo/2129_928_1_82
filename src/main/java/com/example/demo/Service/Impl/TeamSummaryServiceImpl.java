package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.TeamSummaryRecord;
import com.example.demo.Repository.TeamSummaryRecordRepository;

@Service
public class TeamSummaryServiceImpl implements TeamSummaryService {

    private final TeamSummaryRecordRepository repo;

    public TeamSummaryServiceImpl(TeamSummaryRecordRepository repo) {
        this.repo = repo;
    }

    public TeamSummaryRecord generateSummary(String teamName) {
        TeamSummaryRecord t = new TeamSummaryRecord();
        t.setTeamName(teamName);
        return repo.save(t);
    }

    public List<TeamSummaryRecord> getSummariesByTeam(String teamName) {
        return repo.findByTeamName(teamName);
    }

    public List<TeamSummaryRecord> getAllSummaries() {
        return repo.findAll();
    }
}