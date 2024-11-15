package com.example.trend.web.a.dto.planDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

public class PlanRankingDTO {


    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Getter
    public static class PlanRankingResponseDTO{

        @Schema(description = "게시글 제목 입니다")
        String title;

        @Schema(description = "게시글 작성자 닉네임 입니다")
        String nickName;

        @Schema(description = "게시글 좋아요 수 입니다")
        Integer likesCount;

        @Schema(description = "게시글 댓글 수 입니다")
        Integer commentsCount;


    }
}
