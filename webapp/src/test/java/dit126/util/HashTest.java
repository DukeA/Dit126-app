package dit126.util;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertTrue;

public class HashTest {

    private BCryptPasswordEncoder passwordEncoder;

    @Before
    public void setUp() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    public void testPassword() {
        String encoded = passwordEncoder.encode("qwerty");
        assertTrue(BCrypt.checkpw("qwerty", encoded));
    }
}
