package sa.com.mcp.ai.dto;

import java.time.Instant;


public record ParkingCardResponse(String id, String userId, String userName, Instant issuedAt) {
}
