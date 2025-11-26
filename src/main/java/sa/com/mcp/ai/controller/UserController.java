package sa.com.mcp.ai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sa.com.mcp.ai.dto.AuthenticationModel;
import sa.com.mcp.ai.dto.ServicesResponse;
import sa.com.mcp.ai.dto.UserResponse;
import sa.com.mcp.ai.model.User;
import sa.com.mcp.ai.service.UserService;
import sa.com.mcp.ai.service.UserServicesService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService svc;
    private final UserServicesService userServicesService;

    public UserController(UserService svc, UserServicesService userServicesService) {
        this.svc = svc;
        this.userServicesService = userServicesService;
    }

    @GetMapping("/{id}")
    public UserResponse get(@PathVariable String id) {
        User u = svc.getRequired(id);
        return new UserResponse(u.getId(), u.getName(), u.isDisabled(), u.getPrompt());
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody AuthenticationModel authenticationModel) {
        User u = svc.getRequired(authenticationModel.userId());
        return new UserResponse(u.getId(), u.getName(), u.isDisabled(), u.getPrompt());
    }

    @GetMapping("/{id}/services")
    public ServicesResponse getServices(@PathVariable String id) {
        return new ServicesResponse(userServicesService.getUserServicesByUserId(id));
    }
}