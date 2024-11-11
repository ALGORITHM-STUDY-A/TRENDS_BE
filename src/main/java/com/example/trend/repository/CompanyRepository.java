package com.example.trend.repository;

import com.example.trend.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByUsername(String username);

    Boolean existsByUsername(String username);
}
