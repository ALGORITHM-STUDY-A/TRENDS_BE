package com.example.trend.service;

import com.example.trend.domain.Company;
import com.example.trend.domain.enumClass.Role;
import com.example.trend.domain.enumClass.Type;
import com.example.trend.repository.CompanyRepository;
import com.example.trend.web.dto.CompanyJoinDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void joinCompany(CompanyJoinDTO.CompanyJoinRequestDTO request) {

        Company company=Company.builder()
                .username(request.getUsername())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .type(Type.COMPANY)
                .role(Role.ROLE_COM)
                .build();

        companyRepository.save(company);
    }
}
