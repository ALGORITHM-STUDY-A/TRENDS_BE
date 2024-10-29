package com.example.trend.service.companyService;

import com.example.trend.web.dto.CompanyJoinDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface CompanyService {
    void joinCompany(CompanyJoinDTO.CompanyJoinRequestDTO request);
}
