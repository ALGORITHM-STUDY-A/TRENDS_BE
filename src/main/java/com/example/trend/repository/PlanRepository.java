package com.example.trend.repository;

import com.example.trend.domain.Plan;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    @EntityGraph(attributePaths = {"member"})
    List<Plan> findTop4ByOrderByLikesCountDesc();


    @EntityGraph(attributePaths = {"member"})
    @Query("SELECT p FROM Plan p LEFT JOIN p.planLikes l " +
            "WHERE l.createdAt >= :startDate " +
            "GROUP BY p " +
            "ORDER BY COUNT(l) DESC")
    List<Plan> findTop4ByLikesInLastMonth(@Param("startDate") LocalDateTime startDate, Pageable pageable);

}
