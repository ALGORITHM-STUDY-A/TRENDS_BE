package com.example.trend.repository;

import com.example.trend.domain.MemberFollow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberFollowRepository extends JpaRepository<MemberFollow, Long> {
}
