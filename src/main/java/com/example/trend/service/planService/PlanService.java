package com.example.trend.service.planService;

import com.example.trend.web.a.dto.planDTO.PlanBannerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlanService {
    List<PlanBannerDTO.PlanBannerResponseDTO> getPlanBanner();
}
