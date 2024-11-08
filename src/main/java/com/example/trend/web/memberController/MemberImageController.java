package com.example.trend.web.memberController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members/images")
public class MemberImageController {




    @Operation(summary = "프로필 사진 등록 API")
    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadImage(
            @RequestPart(value = "file") MultipartFile multipartFile,
            @AuthenticationPrincipal UserDetails userDetails
    ){

    }


    @Operation(summary = "프로필 사진 조회 API")
    @GetMapping(path = "")
    public void getPetImage(
            @AuthenticationPrincipal UserDetails userDetails
    ){

    }

    @Operation(summary = "프로필 사진 삭제 API")
    @DeleteMapping(path = "")
    public void deletePetImage(
            @AuthenticationPrincipal UserDetails userDetails
    ){

    }


    @Operation(summary = "프로필 사진 업데이트 API")
    @PutMapping(path = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateProfileImage(
            @RequestPart(value = "file") MultipartFile multipartFile,
            @AuthenticationPrincipal UserDetails userDetails
    ) throws IOException {

    }



}