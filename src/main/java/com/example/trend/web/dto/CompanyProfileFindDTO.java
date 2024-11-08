package com.example.trend.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

public class CompanyProfileFindDTO {



    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Getter
    public static class CompanyUsernameRequestDTO {

        @Schema(description = "담당자 이름 입니다")
        String name;

        @Schema(description = "회사명 입니다")
        String companyName;

        @Schema(description = "회사명 입니다<br>"+
        "핸드폰 번호에 대한 인증 외부 API 필요")
        String phoneNumber;


    }




    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Getter
    public static class CompanyPasswordRequestDTO {


        @Schema(description = "담당자 이름 입니다")
        String name;

        @Schema(description = "회사명 입니다")
        String companyName;

        @Schema(description = "회사 이메일 입니다")
        String email;

    }
}
