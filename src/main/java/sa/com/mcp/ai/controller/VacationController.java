package sa.com.mcp.ai.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import sa.com.mcp.ai.dto.CreateVacationRequest;
import sa.com.mcp.ai.dto.VacationResponse;
import sa.com.mcp.ai.model.Vacation;
import sa.com.mcp.ai.service.VacationService;

@RestController
@RequestMapping("/api/vacation-requests")
public class VacationController {
    private final VacationService svc;

    public VacationController(VacationService svc) {
        this.svc = svc;
    }

    @PostMapping
    public VacationResponse create(@Valid @RequestBody CreateVacationRequest req) {
        Vacation vr = svc.create(
                req.userId(),
                req.startDate(),
                req.endDate(),
                req.delegate().userId(),
                req.delegate().name());
        return new VacationResponse(
                vr.getId(),
                vr.getUserId(),
                vr.getStartDate(),
                vr.getEndDate(),
                vr.getDelegateUserId(),
                vr.getDelegateName(),
                vr.getStatus(),
                vr.getCreatedAt());
    }
}
