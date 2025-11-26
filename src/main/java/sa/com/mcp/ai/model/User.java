package sa.com.mcp.ai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String id;

    private String name;

    private boolean disabled;

    private String prompt;

    protected User() {
    }

    public User(String id, String name, boolean disabled, String prompt) {
        this.id = id;
        this.name = name;
        this.disabled = disabled;
        this.prompt = prompt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public String getPrompt() {
        return prompt;
    }
}
