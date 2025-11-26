package sa.com.mcp.ai.dto;

import jakarta.validation.constraints.NotBlank;

public record DelegateInfo(@NotBlank String userId, @NotBlank String name) {
}
