package com.example.trend.domain;

import com.example.trend.domain.common.BaseEntity;
import com.example.trend.domain.enumClass.Category;
import com.example.trend.domain.enumClass.PlanStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Plan extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false, length = 50)
    private String title;
    
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    @Column(nullable = false, length = 50)
    private String target;
    
    @Column(nullable = false)
    @ColumnDefault("0")
    private int cost;
    
    private String bookingMethod;
    
    @Column(nullable = false, columnDefinition = "text")
    private String content;
    
    @Column(nullable = false, columnDefinition = "int default 0")
    private int budget;
    
    @Column(nullable = false, columnDefinition = "int default 0")
    private int likesCount;
    
    @Column(nullable = false)
    private int commentCount;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PlanStatus status;
    
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean contacted;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "plan",cascade = CascadeType.ALL)
    private List<PlanLikes> planLikes=new ArrayList<>();
}
