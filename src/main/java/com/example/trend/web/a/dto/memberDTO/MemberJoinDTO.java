package com.example.trend.web.a.dto.memberDTO;

import com.example.trend.domain.enumClass.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

public class MemberJoinDTO {

    @Getter
    public static class MemberJoinRequestDTO{


        @Schema(description = "회원이름 입니다")
        String name;

        @Schema(description = "회원전화번호 입니다")
        String phoneNumber;

        @Email(message = "올바른 형식의 이메일을 입력해주세요")
        @Schema(description = "회원이메일 입니다")
        String email;

        @Pattern(regexp = "^[a-zA-Z0-9]{6,20}$", message = "사용자 이름은 6~20자의 영문자와 숫자만 포함해야 합니다.")
        @Schema(description = "ID입니다 <br> 6~20자의 영문,숫자")
        String username;

        @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>])[a-zA-Z\\d!@#$%^&*(),.?\":{}|<>]{8,12}$",
                message = "비밀번호는 8~12자의 영문, 숫자, 특수문자를 포함해야 합니다.")
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
