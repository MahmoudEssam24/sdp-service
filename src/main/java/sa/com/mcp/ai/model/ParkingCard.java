package sa.com.mcp.ai.model;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "parking_cards")
public class ParkingCard {
    @Id
    private String id;

    private String userId;
    private String userName;
    private Instant issuedAt;

    protected ParkingCard() {
    }

    public ParkingCard(String userId, String userName) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.userName = userName;
        this.issuedAt = Instant.now();
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Instant getIssuedAt() {
        return issuedAt;
    }
}
