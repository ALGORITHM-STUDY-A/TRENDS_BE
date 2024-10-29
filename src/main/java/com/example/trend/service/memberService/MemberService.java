package com.example.trend.service.memberService;

import com.example.trend.web.dto.MemberJoinDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface MemberService {
    void joinMember(MemberJoinDTO.MemberJoinRequestDTO request);
}
