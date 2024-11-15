package com.example.trend.web.planController;

import com.example.trend.web.a.dto.planDTO.PlanBannerDTO;
import com.example.trend.web.a.dto.planDTO.PlanSearchDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plans")
@RequiredArgsConstructor
@Tag(name = "기획서 API")
public class PlanController {


    // 상단 배너 조회
    // 누적 좋아요수 순으로 4개 조회 - 메인 이미지, title, 기획자 이름, 좋아요 수, 댓글 수, startDate,endDate
    @Operation(summary = "상단 배너 조회 API", description = "해당 API는 게시글을 총 누적 좋아요의 갯수 순으로 조회합니다")
    @GetMapping("/banners")
    public void getPlanBanners(){


    }



    // 이달의 랭킹
    // 한달 누적 좋아요 순으로 조회 - 메인 이미지, title, 기획자 이름, 좋아요 수, 댓글 수
    @Operation(summary = "이달의 랭킹 조회 API", description = "해당 API는 게시글을 한달 간의 누적 좋아요의 갯수 순으로 조회합니다" )
    @GetMapping("/Rankings")
    public void getPlanRanking(){


    }




    // 가장 뜨거운 축제
    // 누적 댓글 순 조회 - 메인 이미지, title, 기획자 이름, 좋아요 수, 댓글 수
    @Operation(summary = "가장 뜨거운 축제 조회 API", description = "해당 API는 게시글을 누적 댓글 갯수 순으로 조회합니다")
    @GetMapping("/hottest")
    public void getHottestPlan(){


    }





    // 테마별 축제
    // 각 테마별 누적 좋아요 순으로 1개씩 조회 - 메인 이미지, title, 기획자 이름, 좋아요 수, 댓글 수
    @GetMapping("/themes")
    @Operation(summary = "테마별 축제 조회 API", description = "해당 API는 게시글을 각 테마별 누적 좋아요 순으로 1개씩 조회합니다")
    public void getPlanByThemes(){


    }




    // 인기유저
    // 팔로워 제일 많은 유저 조회하고 그 유저의 최신 게시글 조회 - 메인 이미지, title, 기획자 이름, 좋아요 수, 댓글 수, 팔로워 수
    @GetMapping("/popular-users")
    @Operation(summary = "인기유저 조회 API", description = "해당 API는 팔로워가 제일 많은 유저를 조회하고 그 유저의 최신 게시글을 조회합니다")
    public void getPlanByPopularUsers(){


    }



    // 검색 API
    @GetMapping("/search")
    @Operation(summary = "게시글 검색 API")
    public void searchPlans(@RequestParam String searchContent){


    }



}
