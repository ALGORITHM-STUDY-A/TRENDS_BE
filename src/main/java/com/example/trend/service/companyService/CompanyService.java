package com.example.trend.service.companyService;

import com.example.trend.web.a.dto.companyDTO.CompanyJoinDTO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface CompanyService {
    CompanyJoinDTO.CompanyJoinResponseDTO joinCompany(CompanyJoinDTO.CompanyJoinRequestDTO request);

    void deleteCompany(String username);

    // 매일 자정에 실행
    @Scheduled(cron = "0 0 0 * * ?")
    void deleteOldInactiveMembers();
}
