package sa.com.mcp.ai.dto;

import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateVacationRequest(
        @NotBlank String userId,
        @NotNull LocalDate startDate,
        @NotNull LocalDate endDate,
        @Valid @NotNull DelegateInfo delegate) {
}