package com.example.trend.domain;

import com.example.trend.domain.enumClass.CommentType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false)
    private String body;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment parentComment;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private Plan plan;
    
    @Column(nullable = false)
    private int likesCount = 0;
    
    @Column(nullable = false)
    private Boolean haveParentComment = false;
    
    private LocalDateTime deletedAt;
    
    @Column(nullable = false)
    private boolean deletedTrue = false;
    
    @Column(nullable = false)
    private int depth = 0;
    
    @Column(nullable = false)
    private int orderNumber;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CommentType type;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;
}
