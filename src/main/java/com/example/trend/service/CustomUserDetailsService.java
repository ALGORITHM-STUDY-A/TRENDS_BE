package com.example.trend.service;


import com.example.trend.domain.Member;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member =memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        if(member!=null){
            return new CustomUserDetails(member);
        }


        return null;
    }
}