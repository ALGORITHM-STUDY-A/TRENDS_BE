package com.example.trend.repository;

import com.example.trend.domain.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {
}
