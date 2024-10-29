package com.example.trend.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /* 시/도 */
    @Column(nullable = false)
    private String province;

    /* 시/군/구 */
    @Column(nullable = false)
    private String city;

    /* 읍/면/동 */
    @Column(nullable = false)
    private String town;

    /* 상세주소 */
    @Column(nullable = false)
    private String details;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
