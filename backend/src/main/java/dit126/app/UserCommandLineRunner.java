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
        userRepository.save(new User("johan"));
        userRepository.save(new User("robin"));
        userRepository.save(new User("adam"));
        userRepository.save(new User("gustav"));
    }
}
