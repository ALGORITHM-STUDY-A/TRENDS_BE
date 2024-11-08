package com.example.trend.web;

import com.example.trend.api.ApiResponse;
import com.example.trend.service.companyService.CompanyService;
import com.example.trend.web.dto.CompanyJoinDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/join")
    public ApiResponse<CompanyJoinDTO.CompanyJoinResponseDTO> joinCompany(@RequestBody CompanyJoinDTO.CompanyJoinRequestDTO request) {

        CompanyJoinDTO.CompanyJoinResponseDTO responseDTO = companyService.joinCompany(request);

        return ApiResponse.onSuccess(responseDTO);
    }


    // 기업 프로필 조회
    // 기업 프로필 수정
    // 기업 프로필 삭제
    // 기업 아이디 찾기
    // 기업 비밀번호 찾기
}
