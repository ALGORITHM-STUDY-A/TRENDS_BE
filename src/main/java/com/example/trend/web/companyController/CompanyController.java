package com.example.trend.web.companyController;

import com.example.trend.api.ApiResponse;
import com.example.trend.service.companyService.CompanyService;
import com.example.trend.web.a.dto.companyDTO.CompanyJoinDTO;
import com.example.trend.web.a.dto.companyDTO.CompanyProfileFindDTO;
import com.example.trend.web.a.dto.companyDTO.CompanyProfileUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
@Tag(name = "기업 정보 관리 API")
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
    public ApiResponse<String> deleteCompany(@AuthenticationPrincipal UserDetails userDetails){

        companyService.deleteCompany(userDetails.getUsername());
        return ApiResponse.onSuccess("성공적으로 삭제 되었습니다");
    }



    // 기업 아이디 찾기 - 회사이름, 담당자 이름, 전화번호 인증
    @Operation(summary = "기업 아이디 찾기 API")
    @GetMapping("/find-usernames")
    public ApiResponse<CompanyProfileFindDTO.CompanyUsernameResponseDTO> getUsernames(CompanyProfileFindDTO.CompanyUsernameRequestDTO request){

        CompanyProfileFindDTO.CompanyUsernameResponseDTO result = companyService.getUsernames(request);

        return ApiResponse.onSuccess(result);
    }


    // 기업 비밀번호 찾기 - 회사 이메일, 이름, 회사 이름를 입력 후 인증번호
    @Operation(summary = "기업 비밀번호 찾기 API")
    @GetMapping("/find-passwords")
    public ApiResponse<CompanyProfileFindDTO.CompanyPasswordResponseDTO> getPasswords(CompanyProfileFindDTO.CompanyPasswordRequestDTO request){

        CompanyProfileFindDTO.CompanyPasswordResponseDTO result = companyService.getPasswords(request);

        return ApiResponse.onSuccess(result);

    }
}
