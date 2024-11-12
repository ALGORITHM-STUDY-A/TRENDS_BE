package com.example.trend.service.memberService;

import com.example.trend.api.code.status.ErrorStatus;
import com.example.trend.api.exception.handler.MemberCategoryHandler;
import com.example.trend.domain.Address;
import com.example.trend.domain.Member;
import com.example.trend.domain.enumClass.Role;
import com.example.trend.domain.enumClass.Status;
import com.example.trend.repository.AddressRepository;
import com.example.trend.repository.MemberRepository;
import com.example.trend.web.a.dto.memberDTO.MemberJoinDTO;
import com.example.trend.web.a.dto.memberDTO.MemberProfileFindDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AddressRepository addressRepository;



    @Override
    public MemberJoinDTO.MemberJoinResponseDTO joinMember(MemberJoinDTO.MemberJoinRequestDTO request){


        /* converter 메서드는 기본적으로 static 메모리를 할당받아 사용하기 때문에
        * bCryptPasswordEncoder를 주입받을 수 없어 회원가입만 컨버터를 사용하지 않겠습니다 */

        duplicateUsername(request.getUsername());

        Member newMember= Member.builder()
                .username(request.getUsername())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .nickname(request.getNickname())
                .role(Role.ROLE_USER)
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .status(Status.ACTIVE)
                .build();

        Member savedMember = memberRepository.save(newMember);

        Address newAddress = Address.builder()
                .province(request.getProvince())  // 시도
                .city(request.getCity())
                .company(null)
                .member(savedMember)              // 주소를 회원과 연결
                .build();

        addressRepository.save(newAddress);


        return MemberJoinDTO.MemberJoinResponseDTO.builder()
                .MemberId(savedMember.getId())
                .build();

    }


    @Override
    public void deleteMember(String username) {

        Member findMember = getMemberByUsername(username);

        findMember.setInactive();  // 객체의 status 필드 수정

    }


    @Override
    public MemberProfileFindDTO.FindMemberUsernameResponseDTO getUsernamesWithPhone(MemberProfileFindDTO.FindMemberUsernameWithPhoneNumbersRequestDTO request){

        Member byPhoneNumber = memberRepository.findByPhoneNumber(request.getPhoneNumber());

        if (byPhoneNumber == null) {
            throw new MemberCategoryHandler(ErrorStatus.MEMBER_NOT_FOUND);
        }

        return MemberProfileFindDTO.FindMemberUsernameResponseDTO.builder()
                .username(byPhoneNumber.getUsername())
                .build();

    }

    @Override
    public MemberProfileFindDTO.FindMemberUsernameResponseDTO getUsernamesWithEmail(MemberProfileFindDTO.FindMemberUsernameWithEmailsRequestDTO request){


        Member byEmail = memberRepository.findByEmail(request.getEmail());
        if (byEmail == null) {
            throw new MemberCategoryHandler(ErrorStatus.MEMBER_NOT_FOUND);
        }


        return MemberProfileFindDTO.FindMemberUsernameResponseDTO.builder()
                .username(byEmail.getUsername())
                .build();
    }

/*    // 비밀번호 재설정 메서드
    public MemberProfileFindDTO.FindMemberPasswordResponseDTO getPassword(MemberProfileFindDTO.FindMemberPasswordRequestDTO request){

        Member byUsername = getMemberByUsername(request.getUsername());



    }*/










    // 매일 자정에 실행
    @Scheduled(cron = "0 0 0 * * ?")
    @Override
    public void deleteOldInactiveMembers() {

        LocalDateTime cutoffDate = LocalDateTime.now().minusDays(30);  // 30일 이전 날짜 계산
        List<Member> membersToDelete = memberRepository.findInactiveMembersForDeletion(Status.INACTIVE, cutoffDate);

        // 30일 지난 회원 삭제
        memberRepository.deleteAll(membersToDelete);

    }


    // username 중복 검사 메서드
    public void duplicateUsername(String username) {
        if (memberRepository.existsByUsername(username)) {
            throw new MemberCategoryHandler(ErrorStatus.MEMBER_USERNAME_DUPLICATE);
        }
    }


    // 회원 찾는 메서드
    public Member getMemberByUsername(String username){
        return memberRepository.findByUsername(username)
                .orElseThrow(()-> new MemberCategoryHandler(ErrorStatus.MEMBER_NOT_FOUND));
    }

}
