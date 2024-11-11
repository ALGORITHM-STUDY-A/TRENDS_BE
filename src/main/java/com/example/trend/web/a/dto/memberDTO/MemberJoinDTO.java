package com.example.trend.web.a.dto.memberDTO;

import com.example.trend.domain.enumClass.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

public class MemberJoinDTO {

    @Getter
    @Setter
    public static class MemberJoinRequestDTO{


        @Schema(description = "회원이름 입니다")
        String name;

        @Schema(description = "회원전화번호 입니다")
        String phoneNumber;

        @Schema(description = "회원이메일 입니다")
        String email;

        @Schema(description = "ID입니다 <br> 6~20자의 영문,숫자")
        String username;

        @Schema(description = "비밀번호입니다.<br>8~12문자의 영문, 숫자, 특수문자를 포함해야 합니다.")
        String password;

        @Schema(description = "회원 닉네임 입니다")
        String nickname;

        Status status= Status.ACTIVE;


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
    public static class MemberJoinResponseDTO{

        Long MemberId;

    }
}
