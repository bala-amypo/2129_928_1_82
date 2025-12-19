package com.example.demo.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entity.TeamSummaryRecord;
import com.example.demo.Service.TeamSummaryService;

@RestController
@RequestMapping("/api/team-summaries")
public class TeamSummaryRecordController {

    private final TeamSummaryService service;

    public TeamSummaryRecordController(TeamSummaryService service) {
        this.service = service;
    }

    @PostMapping("/generate")
    public TeamSummaryRecord generate(@RequestParam String teamName) {
        return service.generateSummary(teamName);
    }

    @GetMapping("/team/{teamName}")
    public List<TeamSummaryRecord> byTeam(@PathVariable String teamName) {
        return service.getSummariesByTeam(teamName);
    }

    @GetMapping
    public List<TeamSummaryRecord> all() {
        return service.getAllSummaries();
    }
}