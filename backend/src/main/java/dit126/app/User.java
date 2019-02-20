package dit126.app;

import lombok.Getter;
import lombok.Setter;

public class User {

    @Getter
    @Setter
    private String name;

    @Getter
    private String username;
    @Getter
    private String password;

    public User(String name) {
        this.name = name;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
