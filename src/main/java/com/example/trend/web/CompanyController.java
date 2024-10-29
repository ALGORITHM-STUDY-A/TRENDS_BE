package com.example.trend.web;

import com.example.trend.service.companyService.CompanyService;
import com.example.trend.web.dto.CompanyJoinDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/join")
    public void joinCompany(@RequestBody CompanyJoinDTO.CompanyJoinRequestDTO request) {
        companyService.joinCompany(request);
    }
}
