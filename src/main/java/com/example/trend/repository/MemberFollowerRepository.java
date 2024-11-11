package com.example.trend.repository;

import com.example.trend.domain.MemberFollower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberFollowerRepository extends JpaRepository<MemberFollower, Long> {
}
