package dit126.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    private final UserRepository userRepository;

    public UserCommandLineRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /*userRepository.save(new ApplicationUser("johan"));
        userRepository.save(new ApplicationUser("robin"));
        userRepository.save(new ApplicationUser("adam"));
        userRepository.save(new ApplicationUser("gustav"));*/
    }
}
