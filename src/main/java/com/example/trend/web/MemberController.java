package com.example.trend.web;

import com.example.trend.api.ApiResponse;
import com.example.trend.service.memberService.MemberService;
import com.example.trend.web.dto.MemberJoinDTO;
import com.example.trend.web.dto.MemberProfileImageDTO;
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

    @PostMapping("/join")
    public ApiResponse<MemberJoinDTO.MemberJoinResponseDTO> join(@RequestBody MemberJoinDTO.MemberJoinRequestDTO request) {

        MemberJoinDTO.MemberJoinResponseDTO response = memberService.joinMember(request);

        return ApiResponse.onSuccess(response);
    }

    @Operation(summary = "프로필 사진 등록 API")
    @PostMapping(path = "/images/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadImage(
            @RequestPart(value = "file") MultipartFile multipartFile,
            @AuthenticationPrincipal UserDetails userDetails
    ){

    }


    @Operation(summary = "프로필 사진 조회 API")
    @GetMapping(path = "/images")
    public void getPetImage(
            @AuthenticationPrincipal UserDetails userDetails
    ){

    }

    @Operation(summary = "프로필 사진 삭제 API")
    @DeleteMapping(path = "/images")
    public void deletePetImage(
            @AuthenticationPrincipal UserDetails userDetails
    ){

    }


    @Operation(summary = "프로필 사진 업데이트 API")
    @PutMapping(path = "/image/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateProfileImage(
            @RequestPart(value = "file") MultipartFile multipartFile,
            @AuthenticationPrincipal UserDetails userDetails
    ) throws IOException{

    }



    // 아이디 찾기 - 휴대폰 번호로 찾기 (인증 외부 API 필요)


    // 비밀번호 찾기 - 아이디,이름,이메일로 찾기

    /*  프로필 조회
        프로필 사진
        닉네임
        팔로워 수
        축제 게시글
     */
}
