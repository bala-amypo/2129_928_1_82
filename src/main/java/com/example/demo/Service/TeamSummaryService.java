package com.example.demo.Service;

import java.util.List;
import com.example.demo.Entity.TeamSummaryRecord;

public interface TeamSummaryService {

    TeamSummaryRecord generateSummary(String teamName);

    List<TeamSummaryRecord> getSummariesByTeam(String teamName);

    List<TeamSummaryRecord> getAllSummaries();
}