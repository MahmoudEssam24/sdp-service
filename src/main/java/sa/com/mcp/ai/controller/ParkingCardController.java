package sa.com.mcp.ai.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import sa.com.mcp.ai.dto.CreateParkingCardRequest;
import sa.com.mcp.ai.dto.ParkingCardResponse;
import sa.com.mcp.ai.model.ParkingCard;
import sa.com.mcp.ai.service.ParkingCardService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/parking-cards")
public class ParkingCardController {
    private final ParkingCardService svc;

    private static List<String> cards = new ArrayList<>();

    public ParkingCardController(ParkingCardService svc) {
        this.svc = svc;
    }

    @PostMapping
    public ParkingCardResponse create(@Valid @RequestBody CreateParkingCardRequest req) {
        ParkingCard card = svc.create(req.userId(), req.userName());
        cards.add("Card");
        return new ParkingCardResponse(card.getId(), card.getUserId(), card.getUserName(), card.getIssuedAt());
    }

    @GetMapping
    public List<String> getCards() {
        return cards;
    }

}
