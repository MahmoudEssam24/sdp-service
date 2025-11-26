package sa.com.mcp.ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sa.com.mcp.ai.model.ParkingCard;

public interface ParkingCardRepository extends JpaRepository<ParkingCard, String> {
}
