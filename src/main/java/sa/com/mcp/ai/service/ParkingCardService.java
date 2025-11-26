package sa.com.mcp.ai.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import sa.com.mcp.ai.model.ParkingCard;
import sa.com.mcp.ai.model.User;
import sa.com.mcp.ai.repository.ParkingCardRepository;

@Service
public class ParkingCardService {
    private final ParkingCardRepository repo;
    private final UserService userService;

    public ParkingCardService(ParkingCardRepository repo, UserService userService) {
        this.repo = repo;
        this.userService = userService;
    }

    public ParkingCard create(String userId, String userName) {
        User user = userService.getRequired(userId);
        if (!user.isDisabled()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "User is not disabled, cannot issue parking card: " + userId);
        }
       
        return repo.save(new ParkingCard(userId, userName));
    }
}
