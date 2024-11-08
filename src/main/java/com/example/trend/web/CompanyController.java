package com.example.trend.web;

import com.example.trend.api.ApiResponse;
import com.example.trend.service.companyService.CompanyService;
import com.example.trend.web.dto.CompanyJoinDTO;
import com.example.trend.web.dto.CompanyProfileFindDTO;
import com.example.trend.web.dto.CompanyProfileUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Operation(summary = "기업 회원가입 API")
    @PostMapping("/join")
    public ApiResponse<CompanyJoinDTO.CompanyJoinResponseDTO> joinCompany(@RequestBody CompanyJoinDTO.CompanyJoinRequestDTO request) {

        CompanyJoinDTO.CompanyJoinResponseDTO responseDTO = companyService.joinCompany(request);

        return ApiResponse.onSuccess(responseDTO);
    }


    // 기업 프로필 조회
    @Operation(summary = "기업프로필 조회 API")
    @GetMapping("/profiles")
    public void getProfiles(@AuthenticationPrincipal UserDetails userDetails){

    }


    // 기업 프로필 수정
    @Operation(summary = "기업프로필 수정 API")
    @PatchMapping("/profiles")
    public void updateProfile(@AuthenticationPrincipal UserDetails userDetails,
                              @RequestBody CompanyProfileUpdateDTO.CompanyProfileUpdateRequestDTO request){

    }



    // 기업 프로필 삭제
    @Operation(summary = "기업 회원탈퇴 API")
    @PatchMapping("")
    public void deleteCompany(@AuthenticationPrincipal UserDetails userDetails){

    }



    // 기업 아이디 찾기 - 회사이름, 담당자 이름, 전화번호 인증
    @Operation(summary = "기업 아이디 찾기 API")
    @GetMapping("/find-usernames")
    public void getUsernames(CompanyProfileFindDTO.CompanyUsernameRequestDTO request){

    }


    // 기업 비밀번호 찾기 - 회사 이메일, 이름, 회사 이름를 입력 후 인증번호
    @Operation(summary = "기업 비밀번호 찾기 API")
    @GetMapping("/find-passwords")
    public void getPasswords(CompanyProfileFindDTO.CompanyPasswordRequestDTO request){

    }
}
