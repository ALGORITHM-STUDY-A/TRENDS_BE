package com.example.trend.repository;

import com.example.trend.domain.Company;
import com.example.trend.domain.Member;
import com.example.trend.domain.enumClass.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByUsername(String username);

    Boolean existsByUsername(String username);

    @Query("SELECT c FROM Company c WHERE c.status = :status AND c.inactiveDate <= :cutoffDate")
    List<Company> findInactiveCompaniesForDeletion(@Param("status") Status status, @Param("cutoffDate") LocalDateTime cutoffDate);
}
