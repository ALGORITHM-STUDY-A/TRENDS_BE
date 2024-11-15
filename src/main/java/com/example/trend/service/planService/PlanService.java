package com.example.trend.service.planService;

import com.example.trend.web.a.dto.planDTO.PlanBannerDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface PlanService {

    List<PlanBannerDTO.PlanBannerResponseDTO> getPlanBanner();

}
