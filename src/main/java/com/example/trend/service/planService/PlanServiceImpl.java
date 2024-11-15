package com.example.trend.service.planService;

import com.example.trend.converter.PlanMainConverter;
import com.example.trend.domain.Plan;
import com.example.trend.domain.PlanRanking;
import com.example.trend.repository.PlanRepository;
import com.example.trend.repository.RankingRepository;
import com.example.trend.web.a.dto.planDTO.PlanBannerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PlanServiceImpl implements PlanService {



    private final PlanRepository planRepository;
    private final RankingRepository rankingRepository;



    @Override
    public List<PlanBannerDTO.PlanBannerResponseDTO> getPlanBanner() {

        List<Plan> topPlans = planRepository.findTop4ByOrderByLikesCountDesc();

        return PlanMainConverter.PlanToPlanBannerDTO(topPlans);
    }


}
