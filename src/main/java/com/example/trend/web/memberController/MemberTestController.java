package com.example.trend.web.memberController;

import com.example.trend.service.memberService.MemberService;
import com.example.trend.web.a.dto.memberDTO.MemberJoinDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberTestController {

    private final MemberService memberService;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("memberJoinRequestDTO", new MemberJoinDTO.MemberJoinRequestDTO());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute MemberJoinDTO.MemberJoinRequestDTO request) {
        // 전달된 request 데이터 로그로 확인
        log.info("Received request: {}", request);

        MemberJoinDTO.MemberJoinResponseDTO response = memberService.joinMember(request);
        return "redirect:/welcome";  // 회원가입 후 이동할 페이지
    }

}
