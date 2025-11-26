package sa.com.mcp.ai.service;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import sa.com.mcp.ai.model.Vacation;
import sa.com.mcp.ai.repository.VacationRequestRepository;

@Service
public class VacationService {
    private final VacationRequestRepository repo;
    private final UserService userService;

    public VacationService(VacationRequestRepository repo, UserService userService) {
        this.repo = repo;
        this.userService = userService;
    }

    public Vacation create(
            String userId,
            LocalDate start,
            LocalDate end,
            String delegateUserId,
            String delegateName) {
        if (start.isAfter(end)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "startDate must be <= endDate");
        }
        userService.getRequired(userId);
        userService.getRequired(delegateUserId);

        return repo.save(new Vacation(userId, start, end, delegateUserId, delegateName));
    }
}
