package com.example.trend.web.a.dto.planDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

public class PlanSearchDTO {


    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Getter
    public static class PlanSearchRequestDTO{

        @Schema(description = "검색 내용 입니다")
        private String content;

    }
}
