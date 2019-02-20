package dit126.app;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/auth")
public class AuthenticationEndpoint {

    private User user = new User("johan","12345");

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("username") String username,
                                     @FormParam("password") String password) {

        try {

            // Authenticate the user using the credentials provided
            if (authenticate(username, password)) {
                // Issue a token for the user
                String token = issueToken(username);

                // Return the token on the response
                return Response.ok(token).build();
            } else {
                return Response.status(Response.Status.FORBIDDEN).build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    private boolean authenticate(String username, String password) throws Exception {
        return (username.equals(user.getUsername()) && password.equals(user.getPassword()));
    }

    private String issueToken(String username) {
        Algorithm algorithm = Algorithm.HMAC256("secret");
        String token = JWT.create()
                .withIssuer("dit126")
                .withClaim("username", username)
                .sign(algorithm);
        return token;
    }
}