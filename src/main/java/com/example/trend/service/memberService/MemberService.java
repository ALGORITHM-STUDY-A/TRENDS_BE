package com.example.trend.service.memberService;

import com.example.trend.web.a.dto.memberDTO.MemberJoinDTO;
import com.example.trend.web.a.dto.memberDTO.MemberProfileFindDTO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface MemberService {

    MemberJoinDTO.MemberJoinResponseDTO joinMember(MemberJoinDTO.MemberJoinRequestDTO request);

    void deleteMember(String username);

    MemberProfileFindDTO.FindMemberUsernameResponseDTO getUsernamesWithPhone(MemberProfileFindDTO.FindMemberUsernameWithPhoneNumbersRequestDTO request);

    // 매일 자정에 실행
    @Scheduled(cron = "0 0 0 * * ?")
    void deleteOldInactiveMembers();

    // username 중복 검사 메서드
    void duplicateUsername(String username);
}
