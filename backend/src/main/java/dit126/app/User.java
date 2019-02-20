package dit126.app;

import lombok.Getter;
import lombok.Setter;

public class User {

    @Getter
    @Setter
    private String name;

    public User(String name) {
        this.name = name;
    }
}
