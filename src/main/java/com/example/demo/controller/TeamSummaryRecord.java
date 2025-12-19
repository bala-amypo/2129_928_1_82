package com.example.demo.controller;

import com.example.demo.entity.TeamSummaryRecord;
import com.example.demo.service.TeamSummaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team-summaries")
public class TeamSummaryController {

    private final TeamSummaryService service;

    public TeamSummaryController(TeamSummaryService service) {
        this.service = service;
    }

    @PostMapping
    public TeamSummaryRecord create(@RequestBody TeamSummaryRecord summary) {
        return service.save(summary);
    }

    @GetMapping
    public List<TeamSummaryRecord> getAll() {
        return service.getAll();
    }
}