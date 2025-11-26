package sa.com.mcp.ai.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sa.com.mcp.ai.model.Services;
import sa.com.mcp.ai.repository.UserServiceRepository;

@Service
public class UserServicesService {

    UserServiceRepository userServiceRepository;

    public UserServicesService(UserServiceRepository userServiceRepository) {
        this.userServiceRepository = userServiceRepository;
    }

    public List<Services> getUserServicesByUserId(String userId) {
        return userServiceRepository.findByUserId(userId);
    }

}
