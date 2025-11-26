package sa.com.mcp.ai.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import sa.com.mcp.ai.model.User;
import sa.com.mcp.ai.repository.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {
    private final UserRepository users;

    public DataLoader(UserRepository users) { this.users = users; }

    @Override
    public void run(String... args) {
        users.save(new User("u100", "Ahmad Ali", true));   // disabled
        users.save(new User("u200", "Sara Noor", false));  // not disabled
        users.save(new User("u300", "Khaled Omar", false));
        users.save(new User("u400", "Mona Salem", true));  // disabled
    }
}
