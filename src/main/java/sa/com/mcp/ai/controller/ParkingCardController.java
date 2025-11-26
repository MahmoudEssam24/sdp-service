package sa.com.mcp.ai.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import sa.com.mcp.ai.dto.CreateParkingCardRequest;
import sa.com.mcp.ai.dto.ParkingCardResponse;
import sa.com.mcp.ai.model.ParkingCard;
import sa.com.mcp.ai.service.ParkingCardService;

@RestController
@RequestMapping("/api/parking-cards")
public class ParkingCardController {
    private final ParkingCardService svc;

    public ParkingCardController(ParkingCardService svc) { this.svc = svc; }

    @PostMapping
    public ParkingCardResponse create(@Valid @RequestBody CreateParkingCardRequest req) {
        ParkingCard card = svc.create(req.userId(), req.userName());
        return new ParkingCardResponse(card.getId(), card.getUserId(), card.getUserName(), card.getIssuedAt());
    }
}
