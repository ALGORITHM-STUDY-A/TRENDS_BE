package com.example.trend.service.companyService;

import com.example.trend.api.code.status.ErrorStatus;
import com.example.trend.api.exception.handler.CompanyCategoryHandler;
import com.example.trend.domain.Address;
import com.example.trend.domain.Company;
import com.example.trend.domain.enumClass.Role;
import com.example.trend.domain.enumClass.Status;
import com.example.trend.repository.AddressRepository;
import com.example.trend.repository.CompanyRepository;
import com.example.trend.web.a.dto.companyDTO.CompanyJoinDTO;
import com.example.trend.web.a.dto.companyDTO.CompanyProfileFindDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

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



    @Override
    public void deleteCompany(String username) {

        Company companyByUsername = getCompanyByUsername(username);
        companyByUsername.setInactive();  // 객체의 status 필드 수정

    }



    @Override
    public CompanyProfileFindDTO.CompanyUsernameResponseDTO findCompanyByUsername(CompanyProfileFindDTO.CompanyUsernameRequestDTO request) {


        Company findCompany = companyRepository.findByName(request.getName())
                .orElseThrow(() -> new CompanyCategoryHandler(ErrorStatus.COMPANY_NOT_FOUND));


        return CompanyProfileFindDTO.CompanyUsernameResponseDTO.builder()
                .username(findCompany.getUsername())
                .build();
    }













    // 매일 자정에 실행
    @Scheduled(cron = "0 0 0 * * ?")
    @Override
    public void deleteOldInactiveCompanies() {

        LocalDateTime cutoffDate = LocalDateTime.now().minusDays(30);  // 30일 이전 날짜 계산
        List<Company> inactiveCompaniesForDeletion = companyRepository.findInactiveCompaniesForDeletion(Status.INACTIVE, cutoffDate);

        // 30일 지난 회원 삭제
        companyRepository.deleteAll(inactiveCompaniesForDeletion);

    }






    // 회원 찾는 메서드
    public Company getCompanyByUsername(String username){
        return companyRepository.findByUsername(username)
                .orElseThrow(()-> new CompanyCategoryHandler(ErrorStatus.COMPANY_NOT_FOUND));
    }


    // username 중복 검사 메서드
    public void duplicateUsername(String username) {
        if (companyRepository.existsByUsername(username)) {
            throw new CompanyCategoryHandler(ErrorStatus.COMPANY_USERNAME_DUPLICATE);
        }
    }
}
