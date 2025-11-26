package sa.com.mcp.ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sa.com.mcp.ai.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
