package com.example.trend.service.authService;


import com.example.trend.domain.Company;
import com.example.trend.domain.Member;
import com.example.trend.repository.CompanyRepository;
import com.example.trend.repository.MemberRepository;
import com.example.trend.web.dto.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final CompanyRepository companyRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Try to find Member
        Member member = memberRepository.findByUsername(username).orElse(null);

        if (member != null) {
            return new CustomUserDetails(member);
        }

        // If Member not found, try to find Company
        Company company = companyRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return new CustomUserDetails(company);

    }
}