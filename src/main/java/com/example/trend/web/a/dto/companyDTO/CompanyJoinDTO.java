package com.example.trend.web.a.dto.companyDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

public class CompanyJoinDTO {

    @Getter
    public static class CompanyJoinRequestDTO{

        String username;
        String password;
        String companyName;

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
