package sa.com.mcp.ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sa.com.mcp.ai.model.Vacation;

public interface VacationRequestRepository extends JpaRepository<Vacation, String> {
}
