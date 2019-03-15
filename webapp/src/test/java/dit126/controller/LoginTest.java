package dit126.controller;

import dit126.controller.login.AppUserSession;
import dit126.controller.login.Credentials;
import dit126.controller.login.Login;
import dit126.model.entity.AppUserEntity;
import dit126.model.facade.LoginFacade;
import dit126.util.exception.IncorrectPasswordException;
import dit126.util.exception.MultipleUsersFoundException;
import dit126.util.exception.UserNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class LoginTest {

    @InjectMocks
    private Login login;

    @Mock
    private Credentials credentials;

    @Mock
    private LoginFacade loginFacade;

    @Mock
    private AppUserSession userSession;

    private AppUserEntity user;

    private String username;

    private String password;

    private BCryptPasswordEncoder encoder;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        user = new AppUserEntity();
        encoder = new BCryptPasswordEncoder();

        username = "test";
        password = "test";
    }

    @Test
    public void testRedirectAfterLogin() {
        when(userSession.getUser()).thenReturn(user);

        assertEquals("index", login.onLoad());
    }

    @Test
    public void testFailedRedirect() {
        when(userSession.getUser()).thenReturn(null);

        assertNull(login.onLoad());
    }

    @Test(expected = UserNotFoundException.class)
    public void userNotFoundException() throws Exception {
        when(loginFacade.login(username, password))
                .thenThrow(UserNotFoundException.class);
        loginFacade.login(username, password);
    }

    @Test(expected = IncorrectPasswordException.class)
    public void incorrectPasswordException() throws Exception {
        when(loginFacade.login(username, password))
                .thenThrow(IncorrectPasswordException.class);
        loginFacade.login(username, password);
    }

    @Test(expected = MultipleUsersFoundException.class)
    public void multipleUsersFoundException() throws Exception {
        when(loginFacade.login(username, password))
                .thenThrow(MultipleUsersFoundException.class);
        loginFacade.login(username, password);
    }

    @Test
    public void successfulLogin() throws Exception {
        String encoded = encoder.encode(password);
        user.setUserName(username);
        user.setUserPassword(encoded);

        when(loginFacade.login(username, password)).thenReturn(user);
        when(userSession.getUser()).thenReturn(user);
        assertTrue(BCrypt.checkpw(password, user.getUserPassword()));
        assertEquals(username, user.getUserName());
        assertNotNull(userSession.getUser());
        assertEquals("index", login.login());
    }

    @Test
    public void incorrectPassword() throws Exception {
        String encoded = encoder.encode(password);
        user.setUserName(username);
        user.setUserPassword(encoded);

        String incorrectPassword = "incorrectPassword";

        assertFalse(BCrypt.checkpw(incorrectPassword, user.getUserPassword()));

        when(loginFacade.login(username, incorrectPassword))
                .thenThrow(IncorrectPasswordException.class);
        try {
            loginFacade.login(username, incorrectPassword);
        } catch (IncorrectPasswordException e) {
            assertNull(userSession.getUser());
            assertNull(login.login());
        }
    }

}
