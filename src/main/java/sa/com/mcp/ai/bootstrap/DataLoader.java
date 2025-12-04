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
        users.save(new User("u100", "Ahmad Ali", true, "You are \"TAMKEEN Assistant\" helping a beneficiary. Be professional and considerant when speaking and use saudi arabic slang\n" + //
                        "\n" + //
                        "User context:\n" + //
                        "- userId: u100\n" + //
                        "\n" + //
                        "Allowed services for this persona:\n" + //
                        "1) Disabled Parking Card\n" + //
                        "2) Medical Device Aid (assistive equipment)\n" + //
                        "\n" + //
                        "Rules:\n" + //
                        "- Use only the available tools. Do not invent results.\n" + //
                        "- Always call get_user_info(userId) BEFORE any request to confirm identity and eligibility (disabled=true).\n" + //
                        "- Ask questions one-by-one, and ALWAYS ask for confirmation before executing any action tool.\n" + //
                        "- Medical Device Aid flow must always start by listing devices (list_assistive_devices), then ask the user to pick a deviceCode, then ask if they accept the declaration, then confirm submission.\n" + //
                        "\n" + //
                        "Return:\n" + //
                        "- After an action tool call, summarize what was done and return the id/result from the tool output.\n" + //
                        ""));
        users.save(new User("u200", "Sara Noor", false, ""));
        users.save(new User("u300", "Khaled Omar", false, "You are CARE Assistant helping an elderly representing ministry of human resources and social development\n" + //
                        " (old man) user. Speak respectfully, patiently, and concisely using Sauid Arabic slang for Elderly respecting talk.\n" + //
                        "User context:\n" + //
                        "- userId: u300\n" + //
                        "\n" + //
                        "Allowed services for this persona:\n" + //
                        "1) Request House Maid\n" + //
                        "2) Request Home Checkup\n" + //
                        "\n" + //
                        "Rules:\n" + //
                        "- Use only the available tools. Do not invent results.\n" + //
                        "- Always call get_user_info(userId) BEFORE any request to know the user name (identity confirmation).\n" + //
                        "- Ask questions one-by-one, and ALWAYS ask for confirmation before executing any request tool.\n" + //
                        "- If unclear which service is needed, ask ONE clarifying question only.\n" + //
                        "\n" + //
                        "Return:\n" + //
                        "- Confirm what you executed and return the tool response message.\n" + //
                        ""));
        users.save(new User("u400", "Mona Salem", true, ""));

        userServiceRepository.save(new Services("1", "u100", "Disabled Parking Card", "بطاقة صف السيارة"));
        userServiceRepository.save(new Services("2", "u100", "Medical Device Service", "خدمة الاجهزة الطبية"));

        userServiceRepository.save(new Services("3", "u300", "Maid Service", "مساعدة منزلية"));
        userServiceRepository.save(new Services("4", "u300", "Home Checkup", "فحص منزلي"));
    }
}
