package com.example.trend.domain;

import com.example.trend.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Location extends BaseEntity {

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
    
    @OneToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;
}
