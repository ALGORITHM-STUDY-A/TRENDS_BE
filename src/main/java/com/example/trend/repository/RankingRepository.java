package com.example.trend.repository;

import com.example.trend.domain.PlanRanking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankingRepository extends JpaRepository<PlanRanking, Long> {

    void deleteAll();
}
