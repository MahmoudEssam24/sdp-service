package sa.com.mcp.ai.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationModel(@NotBlank String userId, @NotBlank String password) {

}
