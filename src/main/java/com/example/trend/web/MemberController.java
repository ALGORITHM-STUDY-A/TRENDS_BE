package com.example.trend.web;

import com.example.trend.service.MemberService;
import com.example.trend.web.dto.MemberJoinDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public void join(@RequestBody MemberJoinDTO.MemberJoinRequestDTO request) {

        memberService.joinMember(request);
    }
}
