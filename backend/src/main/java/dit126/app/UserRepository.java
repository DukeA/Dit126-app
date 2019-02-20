package dit126.app;

import lombok.Getter;

import javax.json.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("/users")
public class UserRepository {

    @Getter
    private List<User> users;

    public UserRepository() {
        users = new ArrayList<User>();
        users.add(new User("johan"));
        users.add(new User("adam"));
        users.add(new User("gustav"));
        users.add(new User("robin"));
    }

    @GET
    @Secured
    public JsonObject toJson() {
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonArrayBuilder userArray = factory.createArrayBuilder();
        for (User user : users) {
            userArray.add(factory.createObjectBuilder().add("name", user.getName()));
        }
        JsonObjectBuilder val = factory.createObjectBuilder()
                .add("users", userArray);
        return val.build();
    }
}
