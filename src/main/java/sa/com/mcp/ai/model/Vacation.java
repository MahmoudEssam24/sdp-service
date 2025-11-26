package sa.com.mcp.ai.model;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vacation_requests")
public class Vacation {
    @Id
    private String id;

    private String userId;

    private LocalDate startDate;
    private LocalDate endDate;

    private String delegateUserId;
    private String delegateName;

    private String status;
    private Instant createdAt;

    protected Vacation() {
    }

    public Vacation(
            String userId,
            LocalDate startDate,
            LocalDate endDate,
            String delegateUserId,
            String delegateName) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.delegateUserId = delegateUserId;
        this.delegateName = delegateName;
        this.status = "SUBMITTED";
        this.createdAt = Instant.now();
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getDelegateUserId() {
        return delegateUserId;
    }

    public String getDelegateName() {
        return delegateName;
    }

    public String getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

}
