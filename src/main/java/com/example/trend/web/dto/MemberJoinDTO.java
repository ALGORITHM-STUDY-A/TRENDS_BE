package com.example.trend.web.dto;

import lombok.Getter;

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
}
