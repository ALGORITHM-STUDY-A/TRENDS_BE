package com.example.trend.web.dto;

import lombok.*;

public class MemberJoinDTO {

    @Getter
    public static class MemberJoinRequestDTO{

        String username;

        String password;

        String name;

        String nickname;

        String phoneNumber;

        String email;


    }

    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Getter
    public static class MemberJoinResponseDTO{

        Long MemberId;

    }
}
