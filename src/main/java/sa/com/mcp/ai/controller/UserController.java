package sa.com.mcp.ai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sa.com.mcp.ai.dto.UserResponse;
import sa.com.mcp.ai.model.User;
import sa.com.mcp.ai.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService svc;

    public UserController(UserService svc) { this.svc = svc; }

    @GetMapping("/{id}")
    public UserResponse get(@PathVariable String id) {
        User u = svc.getRequired(id);
        return new UserResponse(u.getId(), u.getName(), u.isDisabled());
    }
}