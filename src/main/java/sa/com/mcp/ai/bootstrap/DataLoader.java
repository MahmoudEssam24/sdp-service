package sa.com.mcp.ai.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import sa.com.mcp.ai.model.Services;
import sa.com.mcp.ai.model.User;
import sa.com.mcp.ai.repository.UserRepository;
import sa.com.mcp.ai.repository.UserServiceRepository;

@Component
public class DataLoader implements CommandLineRunner {
    private final UserRepository users;
    private final UserServiceRepository userServiceRepository;

    public DataLoader(UserRepository users, UserServiceRepository userServiceRepository) {
        this.users = users;
        this.userServiceRepository = userServiceRepository;
    }

    @Override
    public void run(String... args) {
        users.save(new User("u100", "Ahmad Ali", true));
        users.save(new User("u200", "Sara Noor", false));
        users.save(new User("u300", "Khaled Omar", false));
        users.save(new User("u400", "Mona Salem", true));

        userServiceRepository.save(new Services("1", "u100", "Disabled Parking Card"));
        userServiceRepository.save(new Services("2", "u100", "Vacation Creating"));

        userServiceRepository.save(new Services("3", "u300", "Maid Service"));
        userServiceRepository.save(new Services("4", "u300", "Home Checkup"));
    }
}
