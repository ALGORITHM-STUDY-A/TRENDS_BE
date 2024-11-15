package com.example.trend.converter;

import com.example.trend.domain.Plan;
import com.example.trend.web.a.dto.planDTO.PlanBannerDTO;
import com.example.trend.web.a.dto.planDTO.PlanRankingDTO;

import java.util.List;
import java.util.stream.Collectors;

public class PlanMainConverter {

    public static List<PlanBannerDTO.PlanBannerResponseDTO> PlanToPlanBannerDTO(List<Plan> topPlans) {

        List<PlanBannerDTO.PlanBannerResponseDTO> planBanners = topPlans.stream()
                .map(plan -> PlanBannerDTO.PlanBannerResponseDTO.builder()
                        .title(plan.getTitle())
                        .nickName(plan.getMember().getNickname())
                        .likesCount(plan.getLikesCount())
                        .commentsCount(plan.getCommentCount())
                        .startDate(plan.getStartDate())
                        .endDate(plan.getEndDate())
                        .build())

                .collect(Collectors.toList());

        return planBanners;
    }



    public static List<PlanRankingDTO.PlanRankingResponseDTO> PlanToPlanRankingDTO(List<Plan> topPlans) {

        List<PlanRankingDTO.PlanRankingResponseDTO> planBanners = topPlans.stream()
                .map(plan -> PlanRankingDTO.PlanRankingResponseDTO.builder()
                        .title(plan.getTitle())
                        .nickName(plan.getMember().getNickname())
                        .likesCount(plan.getLikesCount())
                        .commentsCount(plan.getCommentCount())
                        .build())

                .collect(Collectors.toList());

        return planBanners;
    }



}
