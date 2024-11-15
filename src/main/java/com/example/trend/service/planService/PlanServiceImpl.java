package com.example.trend.service.planService;

import com.example.trend.converter.PlanMainConverter;
import com.example.trend.domain.Plan;
import com.example.trend.repository.PlanRepository;
import com.example.trend.web.a.dto.planDTO.PlanBannerDTO;
import com.example.trend.web.a.dto.planDTO.PlanRankingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;

    @Override
    public List<PlanBannerDTO.PlanBannerResponseDTO> getPlanBanner() {

        List<Plan> topPlans = planRepository.findTop4ByOrderByLikesCountDesc();

        return PlanMainConverter.PlanToPlanBannerDTO(topPlans);
    }



    @Transactional
    public void updateMonthlyRanking() {
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(1);

        // 한 달간의 좋아요 갯수를 기준으로 상위 5개 랭킹 조회
        List<Plan> topPlans = planRepository.findTop4ByLikesInLastMonth(oneMonthAgo, PageRequest.of(0, 5));

        // 랭킹 데이터를 DTO로 변환
        List<PlanRankingDTO.PlanRankingResponseDTO> rankingList = PlanMainConverter.PlanToPlanRankingDTO(topPlans);

        // 기존의 랭킹 데이터를 삭제 (새로운 데이터로 덮어씁니다)
        rankingRepository.deleteAll();

        // 새로 계산된 랭킹 데이터를 저장
        saveMonthlyRanking(rankingList);
    }

    // 새로운 랭킹 데이터를 DB에 저장하는 메서드
    public void saveMonthlyRanking(List<PlanRankingDTO.PlanRankingResponseDTO> rankingList) {
        List<PlanRanking> planRankings = rankingList.stream()
                .map(dto -> new PlanRanking(dto.getMainImage(), dto.getTitle(), dto.getCreatorName(), dto.getLikesCount(), dto.getCommentsCount()))
                .collect(Collectors.toList());

        rankingRepository.saveAll(planRankings);  // 새로운 랭킹 데이터를 DB에 저장
    }

}
