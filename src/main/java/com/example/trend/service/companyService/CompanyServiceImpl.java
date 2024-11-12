package com.example.trend.service.companyService;

import com.example.trend.api.code.status.ErrorStatus;
import com.example.trend.api.exception.handler.CompanyCategoryHandler;
import com.example.trend.api.exception.handler.MemberCategoryHandler;
import com.example.trend.domain.Address;
import com.example.trend.domain.Company;
import com.example.trend.domain.Member;
import com.example.trend.domain.enumClass.Role;
import com.example.trend.domain.enumClass.Status;
import com.example.trend.repository.AddressRepository;
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
    private final AddressRepository addressRepository;


    @Override
    public CompanyJoinDTO.CompanyJoinResponseDTO joinCompany(CompanyJoinDTO.CompanyJoinRequestDTO request) {

        duplicateUsername(request.getUsername());

        Company company=Company.builder()
                .username(request.getUsername())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .companyName(request.getCompanyName())
                .role(Role.ROLE_COM)
                .status(Status.ACTIVE)
                .build();

        Company savedCompany = companyRepository.save(company);

        Address newAddress = Address.builder()
                .province(request.getProvince())  // 시도
                .city(request.getCity())
                .member(null)
                .company(savedCompany)          // 주소를 회원과 연결
                .build();

        addressRepository.save(newAddress);

        return CompanyJoinDTO.CompanyJoinResponseDTO.builder()
                .companyId(savedCompany.getId())
                .build();
    }








    // username 중복 검사 메서드
    public void duplicateUsername(String username) {
        if (companyRepository.existsByUsername(username)) {
            throw new CompanyCategoryHandler(ErrorStatus.COMPANY_USERNAME_DUPLICATE);
        }
    }


}
