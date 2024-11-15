package com.example.trend.service.planService;

import com.example.trend.converter.PlanMainConverter;
import com.example.trend.domain.Plan;
import com.example.trend.repository.PlanRepository;
import com.example.trend.web.a.dto.planDTO.PlanBannerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


}
