package com.example.demo.service;

import com.example.demo.entity.TeamSummaryRecord;
import java.util.List;

public interface TeamSummaryService {
    TeamSummaryRecord save(TeamSummaryRecord summary);
    List<TeamSummaryRecord> getAll();
}