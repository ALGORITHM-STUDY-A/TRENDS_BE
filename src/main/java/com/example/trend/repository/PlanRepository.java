package com.example.trend.repository;

import com.example.trend.domain.Plan;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    @EntityGraph(attributePaths = {"member"})
    List<Plan> findTop4ByOrderByLikesCountDesc();

}
