package sa.com.mcp.ai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "services")
public class Services {

    @Id
    private String id;

    private String userId;
    private String nameEn;
    private String nameAr;

    protected Services() {
    }

    public Services(String id, String userId, String nameEn, String nameAr) {
        this.id = id;
        this.userId = userId;
        this.nameEn = nameEn;
        this.nameAr = nameAr;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getNameAr() {
        return nameAr;
    }
}
