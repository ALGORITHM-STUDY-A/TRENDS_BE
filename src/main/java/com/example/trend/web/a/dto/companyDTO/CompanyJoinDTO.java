package com.example.trend.web.a.dto.companyDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.*;

public class CompanyJoinDTO {

    @Getter
    public static class CompanyJoinRequestDTO{


        @Schema(description = "담당자 이름 입니다")
        String name;

        @Schema(description = "회사 전화번호 입니다")
        String phoneNumber;

        @Email(message = "올바른 형식의 이메일을 입력해주세요")
        @Schema(description = "username 입니다 <br> +" +
                "기업은 회원가입 시, username을 이메일로 사용합니다")
        String username;

        @Schema(description = "회사명 입니다")
        String companyName;

        @Schema(description = "회사 비밀번호 입니다")
        String password;


        /* ---------- 주소 ---------- */
        @Schema(description = "시/도 입니다")
        String province;

        @Schema(description = "시/군/구 입니다")
        String city;

    }


    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Getter
    public static class CompanyJoinResponseDTO{

        Long companyId;

    }
}
