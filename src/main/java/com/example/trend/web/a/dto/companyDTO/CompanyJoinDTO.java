package com.example.trend.web.a.dto.companyDTO;

import lombok.*;

public class CompanyJoinDTO {

    @Getter
    public static class CompanyJoinRequestDTO{

        String username;
        String password;
        String companyName;

    }


    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Getter
    public static class CompanyJoinResponseDTO{

        Long companyId;

    }
}