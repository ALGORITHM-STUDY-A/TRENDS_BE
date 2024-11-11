package com.example.trend.service.companyService;

import com.example.trend.domain.Company;
import com.example.trend.domain.enumClass.Role;
import com.example.trend.domain.enumClass.Status;
import com.example.trend.repository.CompanyRepository;
import com.example.trend.web.a.dto.companyDTO.CompanyJoinDTO;
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
    public CompanyJoinDTO.CompanyJoinResponseDTO joinCompany(CompanyJoinDTO.CompanyJoinRequestDTO request) {

        Company company=Company.builder()
                .username(request.getUsername())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .companyName(request.getCompanyName())
                .role(Role.ROLE_COM)
                .status(Status.ACTIVE)
                .build();

        Company savedCompany = companyRepository.save(company);

        return CompanyJoinDTO.CompanyJoinResponseDTO.builder()
                .companyId(savedCompany.getId())
                .build();
    }
}
