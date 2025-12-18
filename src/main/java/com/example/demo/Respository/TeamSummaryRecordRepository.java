package com.example.demo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.TeamSummaryRecord;

public interface TeamSummaryRecordRepository extends JpaRepository<TeamSummaryRecord, Long> {

    List<TeamSummaryRecord> findByTeamName(String teamName);
}