package sa.com.mcp.ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sa.com.mcp.ai.model.Services;
import java.util.List;

public interface UserServiceRepository extends JpaRepository<Services, String> {

    List<Services> findByUserId(String userId);

}
