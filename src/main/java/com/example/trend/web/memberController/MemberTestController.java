package com.example.trend.web.memberController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberTestController {

    @GetMapping("/register")
    public String registerPage() {
        return "register.html"; // templates/register.html.html 파일을 렌더링
    }

}
