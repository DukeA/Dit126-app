package dit126.app;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ApplicationUser {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;

    public ApplicationUser() {

    }

    public ApplicationUser(String name) {
        this.name = name;
    }

    public ApplicationUser(String username, String password) {
        this.username = username;
        this.password = password;
    }



}
