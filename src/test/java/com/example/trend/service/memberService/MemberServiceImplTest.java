package com.example.trend.service.memberService;

import com.example.trend.domain.Member;
import com.example.trend.domain.enumClass.Status;
import com.example.trend.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberServiceImplTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberServiceImpl memberService;

    private Member member;

    @BeforeEach
    void setUp() {
        // member 필드에 초기 상태가 ACTIVE인 Member 객체를 할당
        member = Member.builder()
                .status(Status.ACTIVE)
                .build();
    }

    @Test
    void testDeleteMember() {

        // Given: 특정 username을 가진 Member 객체를 반환하도록 설정
        String username = "testUser";

        when(memberRepository.findByUsername(username)).thenReturn(Optional.of(member));

        // When: deleteMember 메서드 호출
        memberService.deleteMember(username);

        // Then: Member 객체의 status가 INACTIVE로 변경되었는지 확인
        assertEquals(Status.INACTIVE, member.getStatus(), "Member STATUS가 INACTIVE 입니다");
    }
}