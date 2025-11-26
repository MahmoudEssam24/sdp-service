package sa.com.mcp.ai.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateParkingCardRequest(
        @NotBlank String userId,
        @NotBlank String userName) {
}
