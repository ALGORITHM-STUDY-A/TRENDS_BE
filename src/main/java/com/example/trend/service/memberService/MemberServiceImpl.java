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
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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




    // username 중복 검사 메서드
    public void duplicateUsername(String username) {
        if (memberRepository.existsByUsername(username)) {
            throw new MemberCategoryHandler(ErrorStatus.MEMBER_USERNAME_DUPLICATE);
        }
    }


    // 회원 찾는 메서드
    public Member getMemberById(Long id){
        return memberRepository.findById(id)
                .orElseThrow(()-> new MemberCategoryHandler(ErrorStatus.MEMBER_NOT_FOUND));
    }

}
