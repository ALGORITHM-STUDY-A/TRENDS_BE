package com.example.trend.web;

import com.example.trend.api.ApiResponse;
import com.example.trend.service.memberService.MemberService;
import com.example.trend.web.dto.MemberJoinDTO;
import com.example.trend.web.dto.MemberProfileFindDTO;
import com.example.trend.web.dto.MemberProfileImageDTO;
import com.example.trend.web.dto.MemberProfileUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "회원가입 API")
    @PostMapping("/join")
    public ApiResponse<MemberJoinDTO.MemberJoinResponseDTO> join(@RequestBody MemberJoinDTO.MemberJoinRequestDTO request) {

        MemberJoinDTO.MemberJoinResponseDTO response = memberService.joinMember(request);

        return ApiResponse.onSuccess(response);
    }



    //프로필 조회 API
    @Operation(summary = "회원 프로필 조회 API")
    @GetMapping("/profiles")
    public void getProfiles(@AuthenticationPrincipal UserDetails userDetails){

    }



    // 회원 프로필 수정 API
    @Operation(summary = "회원프로필 수정 API")
    @PatchMapping("/profiles")
    public void updateProfile(@AuthenticationPrincipal UserDetails userDetails,
                              @RequestBody MemberProfileUpdateDTO.MemberProfileUpdateRequestDTO request){


    }



    // 회원 탈퇴 API
    @Operation(summary = "회원 탈퇴 API")
    @PatchMapping("/")
    public void deleteMember(@AuthenticationPrincipal UserDetails userDetails){

    }



    // 아이디 찾기 - 휴대폰 번호로 찾기 (인증 외부 API 필요)
    @Operation(summary = "아이디 찾기 API")
    @GetMapping("/find-usernames")
    public void getUsernames(MemberProfileFindDTO.FindMemberUsernameRequestDTO request){

    }





    // 비밀번호 찾기 - 아이디,이름,이메일로 찾기
    @Operation(summary = "비밀번호 찾기 API")
    @GetMapping("/find-passwords")
    public void getPasswords(MemberProfileFindDTO.FindMemberPasswordRequestDTO request){

    }
}


