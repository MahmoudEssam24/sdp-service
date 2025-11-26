package sa.com.mcp.ai.dto;

import java.time.Instant;
import java.time.LocalDate;

public record VacationResponse(
        String id,
        String userId,
        LocalDate startDate,
        LocalDate endDate,
        String delegateUserId,
        String delegateName,
        String status,
        Instant createdAt) {
}