package com.example.trend.service.memberService;

import com.example.trend.web.a.dto.memberDTO.MemberJoinDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface MemberService {
    MemberJoinDTO.MemberJoinResponseDTO joinMember(MemberJoinDTO.MemberJoinRequestDTO request);

    @Transactional
    MemberJoinDTO.MemberJoinResponseDTO joinMemberV2(MemberJoinDTO.MemberJoinRequestDTO request);
}
