package com.example.demo.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entity.AnomalyFlagRecord;
import com.example.demo.Service.AnomalyFlagService;

@RestController
@RequestMapping("/api/anomalies")
public class AnomalyFlagRecordController {

    private final AnomalyFlagService service;

    public AnomalyFlagRecordController(AnomalyFlagService service) {
        this.service = service;
    }

    @PostMapping
    public AnomalyFlagRecord flag(@RequestBody AnomalyFlagRecord f) {
        return service.flagAnomaly(f);
    }

    @PutMapping("/{id}/resolve")
    public AnomalyFlagRecord resolve(@PathVariable Long id) {
        return service.resolveFlag(id);
    }

    @GetMapping
    public List<AnomalyFlagRecord> all() {
        return service.getAllFlags();
    }
}