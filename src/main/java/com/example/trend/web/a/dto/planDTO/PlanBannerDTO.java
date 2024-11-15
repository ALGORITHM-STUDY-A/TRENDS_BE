package com.example.trend.web.a.dto.planDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

public class PlanBannerDTO {

    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Getter
    public static class PlanBannerResponseDTO {

        // 메인 이미지, title, 기획자 이름, 좋아요 수, 댓글 수, startDate,endDate

        @Schema(description = "게시글 제목 입니다")
        String title;

        @Schema(description = "게시글 작성자 닉네임 입니다")
        String nickName;

        @Schema(description = "게시글 좋아요 수 입니다")
        Integer likesCount;

        @Schema(description = "게시글 댓글 수 입니다")
        Integer commentsCount;

        @Schema(description = "기획한 축제의 시작일자 입니다")
        LocalDateTime startDate;

        @Schema(description = "기획한 축제의 종료일자 입니다")
        LocalDateTime endDate;


    }
}
