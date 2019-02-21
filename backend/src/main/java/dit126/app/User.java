package dit126.app;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    private String username;
    @Getter
    private String password;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
