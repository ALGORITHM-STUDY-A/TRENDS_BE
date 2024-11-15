package com.example.trend.web.planController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/festival")
@RequiredArgsConstructor
public class PlanController {


    // 상단 배너 조회
    // 누적 좋아요수 순으로 4개 조회 - 메인 이미지, title, 기획자 이름, 좋아요 수, 댓글 수, startDate,endDate



    // 이달의 랭킹
    // 한달 누적 좋아요 순으로 조회 - 메인 이미지, title, 기획자 이름, 좋아요 수, 댓글 수




    // 가장 뜨거운 축제
    // 누적 댓글 순 조회 - 메인 이미지, title, 기획자 이름, 좋아요 수, 댓글 수




    // 테마별 축제
    // 각 테마별 누적 좋아요 순으로 1개씩 조회 - 메인 이미지, title, 기획자 이름, 좋아요 수, 댓글 수




    // 인기유저
    // 팔로워 제일 많은 유저 조회하고 그 유저의 최신 게시글 조회 - 메인 이미지, title, 기획자 이름, 좋아요 수, 댓글 수, 팔로워 수




    // 검색 API

}
