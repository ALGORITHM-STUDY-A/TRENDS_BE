package com.example.trend.domain;

import com.example.trend.domain.enumClass.Role;
import com.example.trend.domain.enumClass.Type;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /*
        이메일 타입으로 username이 들어가야하지만, 그러면 로그인필터 하나로 두 개의 엔티티를 검증하는데에 들어가는 교체비용이 너무 크기 때문에
        일단 username으로 받았습니다

        추가로 기업의 username 검증하는 로직은 강하게 검증해야 할 것 같습니다
    */
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    // 기업과 개인을 구별하는 필드입니다
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false)
    private String companyName;


}
