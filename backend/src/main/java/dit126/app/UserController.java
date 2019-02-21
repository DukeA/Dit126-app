package dit126.app;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    @CrossOrigin(origins = "http://localhost:3000")
    public Collection<User> getUsers() {
        return userRepository.findAll().stream()
                .collect(Collectors.toList());
    }
}
